package Facade;

import Singleton.SingletonWriter;

public class Test {
    public static void main(String[] args) {
        SimpleFacade sf = new SimpleFacade(); // The client calls only the facade class
        SingletonWriter.getInstance().printLine("Operation 1 : " + sf.operation1(100));
        SingletonWriter.getInstance().printLine("Operation 2 : " + sf.operation2(100));
        SingletonWriter.getInstance().printLine("Operation 3 : " + sf.operation3(100));
    }
}