
public interface Account {

    void withdraw(long withdrawMoney);
    void deposit(long depositMoney);
    void transfer(Account accountTo, long transferMoney);

    long getMoney();
}

abstract class OperationsWithAccount implements Account{

    protected long money;
    protected double procent;


    public void withdraw(long withdrawMoney) {
        money -= withdrawMoney;
    }

    public void deposit(long depositMoney) {
        if (!isValidTransaction(depositMoney)){
//            throw ...
        }
        money += depositMoney;
    }

    public void transfer(Account accountTo, long transferMoney) {
        accountTo.deposit(transferMoney);
        money -= transferMoney;
    }

    protected abstract boolean isValidTransaction(long depositMoney);

}


class CurrentAccount extends OperationsWithAccount {

    private final String type = "Current";

    CurrentAccount(long money, double procent) {
        if (money < 0) {
            this.money = 0;
        }
        else {
            this.money = money;
        }
        this.procent = procent;
    }

    @Override
    public boolean isValidTransaction(long amounOfMoney) {
        if (amounOfMoney > money)
            return false;
        else
            return true;
    }

    @Override
    public void withdraw(long withdrawMoney) {
        if (isValidTransaction(withdrawMoney))
            super.withdraw(withdrawMoney);
    }

    @Override
    public void deposit(long depositMoney) {
        super.deposit(depositMoney);
    }

    @Override
    public void transfer(Account accountTo, long transferMoney) {
        if (isValidTransaction(transferMoney))
            super.transfer(accountTo, transferMoney);
    }

    double getProcent() {
        return procent;
    }

    @Override
    public long getMoney() {
        return money;
    }
}

class DepositAccount extends OperationsWithAccount {

    private final String type = "Deposit";
    private int timeToUnclock;

    DepositAccount(long money, int timeToUnclock) {
        this.money = money;
        this.procent = (double)money / 100000;
        this.timeToUnclock = timeToUnclock;
    }

    boolean isValidTransaction(long amounOfMoney) {
        if ((amounOfMoney > money) || (timeToUnclock > 0))
            return false;
        else
            return true;
    }

    @Override
    public void withdraw(long withdrawMoney) {
        if (isValidTransaction(withdrawMoney))
            super.withdraw(withdrawMoney);
    }

    @Override
    public void deposit(long depositMoney) {
        super.withdraw(depositMoney);
    }

    @Override
    public void transfer(Account accountTo, long transferMoney) {
        if (isValidTransaction(transferMoney))
            super.transfer(accountTo, transferMoney);
    }

    @Override
    public long getMoney() {
        return money;
    }

    double getProcent() {
        return procent;
    }


}

class CreditAccount extends OperationsWithAccount {

    private final String type = "Credit";
    private long creditLimit;
    private final int commisionIfInMinus;

    CreditAccount(long money, long creditLimit, int commisionIfInMinus) {
        this.money = money;
        this.creditLimit = creditLimit;
        this.commisionIfInMinus = commisionIfInMinus;
    }

    boolean isValidTransaction(long amounOfMoney) {
        if (money < 0)
            amounOfMoney += commisionIfInMinus;

        if (amounOfMoney > (money + creditLimit))
            return false;
        else
            return true;
    }

    @Override
    public void withdraw(long withdrawMoney) {
        if (isValidTransaction(withdrawMoney))
            super.withdraw(withdrawMoney);
    }

    @Override
    public void deposit(long depositMoney) {
        super.deposit(depositMoney);
    }

    @Override
    public void transfer(Account accountTo, long transferMoney) {
        if (isValidTransaction(transferMoney))
            super.transfer(accountTo, transferMoney);
    }

    @Override
    public long getMoney() {
        return money;
    }

    int getCommisionIfInMinus() {
        return commisionIfInMinus;
    }

}

class AccountFactory {

    private final double procent = 10;
    private final int commision = 300;

    public Account createCurrentAccount(long money) {
        return new CurrentAccount(money, procent);
    }

    public Account createDepositAccount(long money, int timeToUnlock) {
        return new DepositAccount(money, timeToUnlock);
    }

    public Account createCreditAccount(long money, long creditLimit) {
        return new CreditAccount(money, creditLimit, commision);
    }
}



class SuspiciousAccountDecorator implements Account {

    private static final long niceMoney = 5000;
    private boolean nice;
    protected Account account;

    SuspiciousAccountDecorator(Account acc, boolean nice) {
        this.account = acc;
        this.nice = nice;
    }

    @Override
    public void withdraw(long withdrawMoney) {
        if ((!nice) && (withdrawMoney > niceMoney))
            System.out.println("Can't withdraw that much money");
        else
            account.withdraw(withdrawMoney);
    }

    @Override
    public void deposit(long depositMoney) {
        account.deposit(depositMoney);
    }

    @Override
    public void transfer(Account accountTo, long transferMoney) {
        if ((!nice) && (transferMoney > niceMoney))
            System.out.println("Can't transfer that much money");
        else
            account.transfer(accountTo, transferMoney);
    }

    @Override
    public long getMoney() {
       return account.getMoney();
    }
}