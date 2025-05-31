package Observer;

import Singleton.SingletonWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
// The concrete class that defines the interface features
public class StockMarket implements Subject {
    // The set of observer objects (Client class objects) subscribed to the
    // publisher
    final Set<Client> observerQueue;
    // A map to check and store previous value of all states, used during state
    // transition checking
    final Map<String, Double> tradeMap;

    public StockMarket() { // Default Constructor
        this.observerQueue = new HashSet<>();
        this.tradeMap = new HashMap<>();
    }

    // Function to update the value and push notification to subscribers
    void putTrade(String value, double amt) {
        if (tradeMap.containsKey(value) && tradeMap.get(value) != amt)
            notifyChanges(value, amt);
        else {
            this.tradeMap.put(value, amt);
            notifyChanges(value, amt);
        }
    }

    @Override
    public boolean addRequest(Client object) { // Add to set
        return observerQueue.add(object);
    }

    @Override
    public boolean delRequest(Client object) { // Delete from set
        return observerQueue.remove(object);
    }

    @Override
    // Notifying all attached subscribers
    public void notifyChanges(String stock, double price) {
        SingletonWriter.getInstance().printLine("Changes found !! " + stock + " updated to INR " + price);
        for (Client client : observerQueue)
            client.updateState(stock, price);
    }

}
