package Partitioning.KeyValueHashing;

public interface SST<V> {       // interface defined
    public void balance(int slotIndex);

    Slot<V> getLightSlot();
}
