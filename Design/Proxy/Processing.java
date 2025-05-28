package Proxy;

// Separation of concern: this class only knows how to handle payments
public class Processing implements Payment { // Extending from payments interface

    @Override
    // Your main processing logic can be laid here
    public void processPayment(int amount) {
        System.out.println("The amount is processed...");
    }
}
