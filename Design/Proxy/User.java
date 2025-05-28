package Proxy;

public class User {
    private int balance;

    public User(int bal) {
        this.balance = bal;
    }

    public void setBalance(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
