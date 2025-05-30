package Strategy;

import Singleton.SingletonWriter;

class CreditSystem implements Payments {

    private final String card;
    private int balance;

    public CreditSystem(String cardnumber, String balance) {
        this.card = cardnumber;
        this.balance = Integer.parseInt(balance);
    }

    @Override
    public void pay(int amt) {
        SingletonWriter.getInstance().dashLine();
        SingletonWriter.getInstance().printLine("CREDIT STRATEGY");
        SingletonWriter.getInstance().printLine("Card number found : " + card);
        SingletonWriter.getInstance().printLine("Balance : " + balance);
        balance -= amt;
        SingletonWriter.getInstance().printLine("Balance : " + balance);
    }
}
