import java.util.ArrayList;
import java.util.List;

public class Client {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String passportNumber;
    private List<Account> accountList;

    private Client (String firstName, String lastName, String address, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passportNumber = passportNumber;
        this.accountList = new ArrayList<Account>();
        }


    public static class Builder {
        private String firstName;
        private String lastName;
        private String address;
        private String passportNumber;

        public Builder (String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Builder withAddress (String address) {
            this.address = address;
            return this;
        }

        public Builder withpassportNumber (String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public Client build() {
            return new Client(firstName, lastName, address, passportNumber);
        }
    }


    public static Builder builder(String firstName, String lastName) {
        return new Builder(firstName, lastName);
    }



    void addAccount(Account account) {
        this.accountList.add(account);
    }

     Account getAccount(int i) {
        return accountList.get(i);
     }

     boolean getNice() {
        if ((this.address.equals("")) || (this.passportNumber.equals(""))) {
            return false;
        }
        else
            return true;
     }
}

