public class Test {

    public static void main(String[] args) {
        testFactory();
    }

    private static void testFactory() {
        // Factory instance is used to preform tests and check if the objects are being created or not
        Clothes shirt = FactorySingleton.getInstance().createClothes("shirt", "Cotton", "Nike", "Blue");
        Clothes hoodie = FactorySingleton.getInstance().createClothes("hoodie", "Polyester", "Adidas", "Black", true);
        Clothes blazer = FactorySingleton.getInstance().createClothes("blazer", "Wool", "Hugo Boss", "Navy", false);
        shirt.extract(); hoodie.extract(); blazer.extract();
        System.out.println("Factory instance: "+FactorySingleton.getInstance().getClass().getSimpleName()+"@"+Integer.toHexString(FactorySingleton.getInstance().hashCode()));
    }
}
