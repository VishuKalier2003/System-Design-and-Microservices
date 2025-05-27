package Singleton;

public class SingletonWriter {
    
    private SingletonWriter() {}

    private static class WriterLoader {
        private static final Printer INSTANCE = new Printer();
    }

    public static Printer getInstance() {
        return WriterLoader.INSTANCE;
    }
}
