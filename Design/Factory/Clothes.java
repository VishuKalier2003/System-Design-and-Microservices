// Abstract class for storing common properties among different classes extending the abstract class
abstract class Clothes {
    protected String fabric;        // Common property among all clothes

    public Clothes(String fabric) {
        this.fabric = fabric;
    }

    @SuppressWarnings("unused")
    abstract void extract();        // Function to be overriden in every subclass
}