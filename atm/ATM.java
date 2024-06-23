package atm;

import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<Long, Account> accounts;

    public ATM() {
        accounts = new HashMap<>();
        // Sample accounts
        accounts.put(18002082244L, new Account(18002082244L, 1234, 1000.0));
        accounts.put(234567L, new Account(234567L, 2345, 2000.0));
    }

    public Account authenticateUser(long accountNumber, int pin) {
        Account account = accounts.get(accountNumber);
        if (account != null && account.validatePin(pin)) {
            return account;
        }
        return null;
    }
}
