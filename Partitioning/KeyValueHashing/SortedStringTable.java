package Partitioning.KeyValueHashing;

import Singleton.SingletonWriter;
import java.util.PriorityQueue;

public class SortedStringTable<V> implements SST<V> {

    private final PriorityQueue<Slot<V>> minHeap;
    private final Slot<V>[] slots;

    @SuppressWarnings("unchecked")
    public SortedStringTable(int n) {
        this.minHeap = new PriorityQueue<>((a, b) -> {
            if(a.getLoadRatio() == b.getLoadRatio())
                return Integer.compare(a.getSlotIndex(), b.getSlotIndex());
            return Double.compare(a.getLoadRatio(), b.getLoadRatio());
        });
        slots = new Slot[n];
        for(int i = 0; i < n; i++) {
            slots[i] = new Slot<>(0, 10, i);
            minHeap.add(slots[i]);
        }
    }

    @Override
    public void balance(int slotIndex) {
        Slot<V> original = this.slots[slotIndex];
        slots[slotIndex].setIndex(slots[slotIndex].getIndex()+1);
        slots[slotIndex].setLoadRatio((slots[slotIndex].getIndex()+0.0d)/slots[slotIndex].getSize());
        addLightSlot(original);
    }

    public int getTopSlotIndex() {
        return getLightSlot().getSlotIndex();
    }

    @Override
    public Slot<V> getLightSlot() {
        return minHeap.poll();
    }

    public void addLightSlot(Slot<V> v) {
        this.minHeap.add(v);
    }

    public void addDataToSlot(Object data) {
        int slotIndex = getLightSlot().getSlotIndex();
        this.slots[slotIndex].addDataToBlock(data);
        balance(slotIndex);
    }

    public Slot<V> peekLightSlot() {
        return this.minHeap.peek();
    }

    public void loadFactorList() {
        for(Slot<V> v : slots)
            SingletonWriter.getInstance().printLine("slot index : "+v.getSlotIndex()+" load ratio : "+v.getLoadRatio());
    }

    public Slot<V> getSlotByIndex(int index) {
        return this.slots[index-1];
    }
}
