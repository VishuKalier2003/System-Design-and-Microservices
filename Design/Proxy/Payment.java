package Proxy;

// This proxy design of the entire package is the Canonical control path design
public interface Payment {
    public void processPayment(int amount);
}