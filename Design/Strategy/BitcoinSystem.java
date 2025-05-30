package Strategy;

import Singleton.SingletonWriter;

class BitcoinSystem implements Payments {

    private final String bitcoin;
    private double balance;

    public BitcoinSystem(String bit, String balance) {
        this.bitcoin = bit;
        this.balance = Double.parseDouble(balance);
    }

    @Override
    public void pay(int amt) {
        SingletonWriter.getInstance().dashLine();
        SingletonWriter.getInstance().printLine("BITCOIN STRATEGY");
        SingletonWriter.getInstance().printLine("Card number found : " + bitcoin);
        SingletonWriter.getInstance().printLine("Balance : " + balance);
        balance -= amt;
        SingletonWriter.getInstance().printLine("Balance : " + balance);
    }
}
