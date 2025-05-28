package Proxy;

import Singleton.SingletonWriter;

// Separation of concern: This class holds logic about "Should we process the payment?"
public class UserPayments implements Payment {
    // Implements the same interface as of processing class hence holds a reference
    // to the subject

    Processing processing;
    User user;

    public UserPayments(User user) {
        this.user = user;
        this.processing = new Processing();
    }

    @Override
    public void processPayment(int amount) {
        // All validation logic remains in one place (under one class), without
        // polluting processing code
        if (!nameCheck())
            SingletonWriter.getInstance().printLine("Error in name... payment cannot be processed");
        else if (!balanceCheck())
            SingletonWriter.getInstance().printLine("Amount too low... payment cannot be processed");
        else {
            SingletonWriter.getInstance().printLine("Checks met... Processing started on Rs. " + user.getBalance());
            user.setBalance(amount);
            processing.processPayment(amount);
            SingletonWriter.getInstance().printLine("Payment completed on Rs. " + user.getBalance());
        }
    }

    // New checks like these can be injected here, without touching the processing
    // class (the real subject)
    private boolean nameCheck() {
        boolean upper = false, lower = false;
        String name = user.name;
        int n = name.length();
        for (int i = 0; i < n; i++) {
            char ch = name.charAt(i);
            if (Character.isUpperCase(ch))
                upper = true;
            else if (Character.isLowerCase(ch))
                lower = true;
        }
        return upper && lower;
    }

    private boolean balanceCheck() {
        return user.getBalance() >= 5000;
    }
}
