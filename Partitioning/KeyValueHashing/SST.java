package Partitioning.KeyValueHashing;

public interface SST<V> {
    public void balance(int slotIndex);

    Slot<V> getLightSlot();
}
