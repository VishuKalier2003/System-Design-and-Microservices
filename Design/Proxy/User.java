package Proxy;

// We can mock user separately into unit testing later
public class User {
    private int balance;
    String name;

    public User(int bal, String name) {
        this.balance = bal;
        this.name = name;
    }

    public void setBalance(int amount) {
        this.balance -= amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return this.balance;
    }

    public String getName() {
        return this.name;
    }
}
