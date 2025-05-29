package Adapter;

import Singleton.SingletonWriter;

public class Test {
    public static void main(String[] args) {
        VoltageAdapter adapter = new VoltageAdapter();
        SingletonWriter.getInstance().printLine("Voltage of Adaptee : " + adapter.fiveVolt.current);
        SingletonWriter.getInstance().printLine("Voltage dropped to : " + adapter.getCurrent());
        SingletonWriter.getInstance().printLine("Voltage of Adaptee : " + adapter.fiveVolt.current);
    }
}
