package Partitioning.KeyValueHashing;

import Singleton.SingletonWriter;

// Extending abstract class to add additional features
public class Slot<V> extends Data<V> {
    private final int size, slotIndex;
    private int index;
    private double loadRatio;

    public Slot(double lr, int s, int sl) {
        super();
        this.slotIndex = sl;
        this.index = 0;
        this.size = s;
        this.loadRatio = (this.index + 0.0d) / this.size;
    }

    @Override       // Function overriding of the abstract method
    public void showData() {
        SingletonWriter.getInstance().printLine("Slot Index : "+slotIndex);
        for(V v : this.getValue())
            SingletonWriter.getInstance().printLine("Data : "+v.toString());
        SingletonWriter.getInstance().printLine("Slot Data index : "+index);
        SingletonWriter.getInstance().printLine("Slot Load Ratio : "+loadRatio);
    }

    // Getters and Setters
    public void setLoadRatio(double lr) {this.loadRatio = lr; setIndex((int)lr);}
    public void setIndex(int x) {this.index = x;}

    public void addDataToBlock(Object data) {this.addData(data);}

    public int getSlotIndex() {return this.slotIndex;}
    public double getLoadRatio() {return this.loadRatio;}
    public int getIndex() {return this.index;}
    public int getSize() {return this.size;}
}
