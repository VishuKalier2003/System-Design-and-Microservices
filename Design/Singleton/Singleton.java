// Info: Singleton pattern where a class will have one and only one instance for a program
public class Singleton {
    
    private Singleton() {}

    // Info: There is no way to access data attribute without calling Singleton Loader
    private static class SingletonLoader {
        private static final Data data = new Data(1, "Test log");
    }

    /**
     * @return the singleton instance
     */
    public static Data getInstance() {
        // This function will load the Singleton Loader class the first time, then call the final data attribute again and again
        return SingletonLoader.data;
    }

    public static void main(String[] args) {
        // Info: No matter how many instance we create, we will always fetch same value following the Singleton property
        Data data1 = Singleton.getInstance();       // First instance created
        data1.print();
        Data data2 = Singleton.getInstance();       // Second instance created
        data2.print();
        // We can directly call the instance without creating objects, since the class will have one instance created at Compile or Run time
        Singleton.getInstance().print();
    }
}
