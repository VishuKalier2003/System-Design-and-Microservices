package Partitioning.KeyValueHashing;

import Singleton.SingletonWriter;
import java.util.PriorityQueue;

public class SortedStringTable<V> implements SST<V> {

    // Heap to store the Slots as per their increasing load factors
    private final PriorityQueue<Slot<V>> minHeap;
    // Sorted String Table as the array of slots
    private final Slot<V>[] slots;

    @SuppressWarnings("unchecked")
    public SortedStringTable(int n) {
        // defining the Priority Queue
        this.minHeap = new PriorityQueue<>((a, b) -> {
            if(a.getLoadRatio() == b.getLoadRatio())    // If same load factor
                return Integer.compare(a.getSlotIndex(), b.getSlotIndex()); // sort by slot index
            return Double.compare(a.getLoadRatio(), b.getLoadRatio());
        });
        slots = new Slot[n];
        for(int i = 0; i < n; i++) {        // Initialize and fill the heap
            slots[i] = new Slot<>(0, 10, i);
            minHeap.add(slots[i]);
        }
    }

    @Override       // Function overriding since implements interface
    public void balance(int slotIndex) {
        Slot<V> original = this.slots[slotIndex];       // Extract the slot from table
        // Update internal index and load factor
        slots[slotIndex].setIndex(slots[slotIndex].getIndex()+1);
        slots[slotIndex].setLoadRatio((slots[slotIndex].getIndex()+0.0d)/slots[slotIndex].getSize());
        addLightSlot(original);     // push back into heap with updated load factor
    }

    public int getTopSlotIndex() {      // extract top slot index
        return getLightSlot().getSlotIndex();
    }

    @Override       // Function overriding since implements interface
    public Slot<V> getLightSlot() {
        return minHeap.poll();
    }

    // declared private since we want addition done to the heap only by the class itself (Proxy pattern)
    private void addLightSlot(Slot<V> v) {       // Add slot into the heap
        this.minHeap.add(v);
    }

    public void addDataToSlot(Object data) {
        int slotIndex = getLightSlot().getSlotIndex();
        this.slots[slotIndex].addDataToBlock(data); // Add data function of Slot class
        balance(slotIndex);
    }

    public Slot<V> peekLightSlot() {
        return this.minHeap.peek();
    }

    public void loadFactorList() {      // print load factor list
        for(Slot<V> v : slots)
            SingletonWriter.getInstance().printLine("slot index : "+v.getSlotIndex()+" load ratio : "+v.getLoadRatio());
    }

    public Slot<V> getSlotByIndex(int index) {
        return this.slots[index-1];
    }
}
