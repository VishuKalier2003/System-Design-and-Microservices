package Proxy;

public class Processing implements Payment {
    @Override
    public void processPayment(int amount) {
        System.out.println("The amount is processed...");
    }
}
