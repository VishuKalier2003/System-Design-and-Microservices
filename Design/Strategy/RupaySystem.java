package Strategy;

import Singleton.SingletonWriter;

class RupaySystem implements Payments {

    private final String card, holder;
    private int balance;

    public RupaySystem(String cardnumber, String balance, String holder) {
        this.card = cardnumber;
        this.holder = holder;
        this.balance = Integer.parseInt(balance);
    }

    @Override
    public void pay(int amt) {
        SingletonWriter.getInstance().dashLine();
        SingletonWriter.getInstance().printLine("RUPAY STRATEGY");
        SingletonWriter.getInstance().printLine("Card number found : " + card);
        SingletonWriter.getInstance().printLine("Holder name : " + holder);
        SingletonWriter.getInstance().printLine("Balance : " + balance);
        balance -= amt;
        SingletonWriter.getInstance().printLine("Balance : " + balance);
    }
}
