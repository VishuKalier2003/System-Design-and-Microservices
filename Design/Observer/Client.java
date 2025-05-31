package Observer;

import Singleton.SingletonWriter;
import java.util.HashMap;
import java.util.Map;

public class Client implements Observer {
    private final Map<String, Double> stocks; // Stocks or states map that each client will hold

    public Client() {
        this.stocks = new HashMap<>();
    }

    @Override
    public boolean joinPublisher(StockMarket sub) { // Join request from current subscriber
        return sub.addRequest(this);
    }

    @Override
    public boolean signOutPublisher(Subject sub) { // Leave request from current subscriber
        return sub.delRequest(this);
    }

    @Override // State transition logic
    public void updateState(String stock, double newPrice) {
        stocks.put(stock, newPrice);
    }

    public void showStocks(String client) { // Simple print function of states
        System.out.println("Client stock table : " + client);
        for (Map.Entry<String, Double> entry : this.stocks.entrySet())
            SingletonWriter.getInstance().printLine("Stock : " + entry.getKey() + " value : " + entry.getValue());
    }
}
