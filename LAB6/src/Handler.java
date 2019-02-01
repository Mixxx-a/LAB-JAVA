public abstract class Request<T> {

    protected Request<T> request;

    public void setRequest(Request<T> request) {
        this.request = request
    }
}

class CurrentAccountHandler implements Handler {

    CurrentAccount currAcc;

    CurrentAccountHandler(CurrentAccount currAcc) {
        this.currAcc = currAcc;
    }

    @Override
    public void handleRequest() {
        double additionalMoney = currAcc.getMoney() * currAcc.getProcent();
        currAcc.deposit((long)additionalMoney);
    }
}

class DepositAccountHandler implements Handler {
    DepositAccount depAcc;

    DepositAccountHandler(DepositAccount depAcc) {
        this.depAcc = depAcc;
    }

    @Override
    public void handleRequest() {
        double additionalMoney = depAcc.getMoney() * depAcc.getProcent();
        depAcc.deposit((long)additionalMoney);
    }
}

class CreditAccountHandler implements Handler {
    CreditAccount credAcc;

    CreditAccountHandler(CreditAccount credAcc) {
        this.credAcc = credAcc;
    }

    public void handleRequest() {
        credAcc.withdraw(credAcc.getCommisionIfInMinus());
    }
}

successor



