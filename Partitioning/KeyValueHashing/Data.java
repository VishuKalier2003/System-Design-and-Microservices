package Partitioning.KeyValueHashing;

import java.util.ArrayList;
import java.util.List;

public abstract class Data<V> {     // abstract class defined as Base model
    private final List<V> value;        // list of data

    protected Data() {
        this.value = new ArrayList<>();
    }

    public abstract void showData();        // abstract function to be overriden

    public List<V> getValue() {return this.value;}
    
    @SuppressWarnings("unchecked")
    public void addData(Object data) {this.value.add((V)data);}
}
