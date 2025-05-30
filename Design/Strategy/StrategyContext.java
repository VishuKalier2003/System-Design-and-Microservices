package Strategy;

// Context object using the Strategy object
class StrategyContext {

    enum Mode { // Using enums for better abstraction
        CREDIT, RUPAY, BITCOIN;
    }

    private Mode mode;
    private Payments payments; // Strategy object

    // Instead of String params... we can use Builder strategy here as well
    public StrategyContext(String mode, String... params) {
        this.mode = Mode.valueOf(mode.toUpperCase());
        switch (this.mode) {
            // Credit strategy, takes only two inputs
            case CREDIT -> this.payments = new CreditSystem(params[0], params[1]);
            // Rupay Strategy, takes 3 inputs
            case RUPAY -> this.payments = new RupaySystem(params[0], params[1], params[2]);
            // Bitcoin strategy, takes 2 inputs where the balance is a floating point value
            case BITCOIN -> this.payments = new BitcoinSystem(params[0], params[1]);
        }
    }

    public void payments(int amt, String... params) { // Payment operations
        this.payments.pay(amt);
    }

}
