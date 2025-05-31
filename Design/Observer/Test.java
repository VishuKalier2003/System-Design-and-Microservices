package Observer;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StockMarket sm = new StockMarket();
            Client c1 = new Client(), c2 = new Client(), c3 = new Client();
            // Two clients added to the stock market (publisher)
            sm.addRequest(c1);
            sm.addRequest(c2);
            // All currently empty, since no update
            c1.showStocks("c1");
            c2.showStocks("c2");
            c3.showStocks("c3");
            // c1 and c2 updated
            sm.putTrade("BTC", 37.182903); // notify all clients (observers)
            sm.addRequest(c3);
            c1.showStocks("c1");
            c2.showStocks("c2");
            c3.showStocks("c3");
            // All updated
            sm.putTrade("BTC", 126.287591); // notify all clients (observers)
            c1.showStocks("c1");
            c2.showStocks("c2");
            c3.showStocks("c3");
            // All updated
            sm.putTrade("UTS", 1780.987613); // notify all clients (observers)
            c1.showStocks("c1");
            c2.showStocks("c2");
            c3.showStocks("c3");
            sm.delRequest(c2); // Remove from the stock market (publisher)
            // c1 and c3 updated only, since c2 is removed
            sm.putTrade("UBC", 11.2987109); // notify all clients (observers)
            c1.showStocks("c1");
            c2.showStocks("c2");
            c3.showStocks("c3");
            sc.close();
        }
    }

}
