package Partitioning.KeyValueHashing;

import java.util.ArrayList;
import java.util.List;

public abstract class Data<V> {
    private final List<V> value;

    protected Data() {
        this.value = new ArrayList<>();
    }

    public abstract void showData();

    public List<V> getValue() {return this.value;}
    
    @SuppressWarnings("unchecked")
    public void addData(Object data) {this.value.add((V)data);}
}
