package databases;

import java.util.HashMap;
import java.util.Map;

public class AccountsDB {
    private static volatile AccountsDB accountsDB;
    private final Map<String, String> users;

    private AccountsDB() {
        users = new HashMap<>();
    }

    public static synchronized AccountsDB getInstance() {
        if (accountsDB == null) {
            accountsDB = new AccountsDB();
        }
        return accountsDB;
    }


    public synchronized Map<String, String> getUsers() {
        return new HashMap<>(users);
    }

    public synchronized void createAccount(String login, String password) {
        users.put(login, password);
    }

}
