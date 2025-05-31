package Observer;

public interface Observer {
    // Request function to join the Publisher
    public boolean joinPublisher(StockMarket sub);

    // Request function to join the Publisher
    public boolean signOutPublisher(Subject sub);

    // The update State(stock, value) that is used to update the previous state
    public void updateState(String stock, double newPrice);
}
