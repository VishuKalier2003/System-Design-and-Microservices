package Adapter;

// The Voltage Adapter class that wraps the Adapter interface
public class VoltageAdapter implements ThreeVolt {
    protected final FiveVolt fiveVolt;

    public VoltageAdapter() {
        // New instance is created
        this.fiveVolt = new FiveVolt();
    }

    @Override
    public int getCurrent() {
        if (fiveVolt.getCurrent() == 5) {
            fiveVolt.setCurrent(3); // Update the data member
            return 3;
        }
        return -1;
    }
}
