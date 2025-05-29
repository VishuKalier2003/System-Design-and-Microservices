package Adapter;

// The class that needs to be modified (Adaptee class)
public class FiveVolt {

    protected int current;

    public FiveVolt() {
        this.current = 5;
    }

    public int getCurrent() { // The function that needs to be modified
        return current;
    }

    protected void setCurrent(int value) {
        this.current = value;
    }
}
