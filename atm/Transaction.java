package atm;

public class Transaction {
    private Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
