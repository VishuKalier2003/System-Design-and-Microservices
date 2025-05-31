package Observer;

// Interface that holds the necessary methods of Subscriber abstracted
public interface Subject {
    // Add request from subscriber to publisher
    public boolean addRequest(Client object);

    // Remove request from subscriber to publisher
    public boolean delRequest(Client object);

    // The state (stock, price) is maintained by the publisher
    public void notifyChanges(String stock, double price);
}