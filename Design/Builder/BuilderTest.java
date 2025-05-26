public class BuilderTest {
    
    public static void main(String[] args) {
        Product product1 = new Product.ProductBuilder().data(12).build();
        Product product2 = Product.builder().data(18).value(16.05).build();
        product1.print();
        product2.print();
    }
}
