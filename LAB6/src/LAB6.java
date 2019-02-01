public class LAB6 {
    public static void main(String[] args) {
        Client client1 = Client.builder("Ivan", "Ivanov")
                .withAddress("SPB, Red st.")
                .withpassportNumber("ABC12345")
                .build();
        Client client2 = Client.builder("Andey", "Ivanov")
                .build();

        AccountFactory factory = new AccountFactory();
        Account acc1 = factory.createCurrentAccount(100000);
        Account acc2 = factory.createDepositAccount(10000, 3600);
        Account acc3 = factory.createCreditAccount(50000, 5000);

        client1.addAccount(acc1);
        client1.addAccount(acc2);
        client1.addAccount(acc3);

        client1.getAccount(0).withdraw(5000);

        Account acc4 = new SuspiciousAccountDecorator(acc1, client1.getNice());



    }
}
