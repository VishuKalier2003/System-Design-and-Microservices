public class BuilderTest {
    
    public static void main(String[] args) {
        Product product1 = new Product.ProductBuilder().data(12).build();
        /**  
         * Product.builder() will fetch a new Product Builder object 
         * that object values will be setted by the setters and setters will return the same object after operations
         * then the build() function will call the contrcutor of the outer class using return new Outer(this), which will
         * invoke the constructor and set the parameters of the outer class by mapping the values from the inner class
        */
        Product product2 = Product.builder().data(18).value(16.05).build();
        product1.print();
        product2.print();
    }
}
