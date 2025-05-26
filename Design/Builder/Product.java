
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

class Product {
    private final int data;
    private final double value;

    // Keep the inner class public or default since it needs to be accessed by other classes
    static class ProductBuilder {
        private int data;
        private double value;

        public ProductBuilder data(int x) {        // Data setter
            this.data = x; return this;
        }

        public ProductBuilder value(double v) {        // Value setter
            this.value = v; return this;
        }

        // This build function initializes the private parametrized constructor of Product class
        public Product build() {
            return new Product(this);
        } 
    }

    // Parametrized Constructor that is accessed when inner class build() function is invoked 
    private Product(ProductBuilder builder) {
        this.data = builder.data;
        this.value = builder.value;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();        // Direct inner class instantiation function in outer class
    }

    public int getData() {return this.data;}        // Data Getter
    public double getValue() {return this.value;}   // Value Getter

    public void print() {
        final StringBuilder output = new StringBuilder();
        final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
        output.append("Product Key : ").append(this.hashCode()).append("\n");
        output.append("Data : ").append(getData()).append("\n");
        output.append("Value : ").append(getValue()).append("\n");
        writer.write(output.toString());
        writer.flush();
    }
}
