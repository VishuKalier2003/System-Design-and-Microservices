
// Since it is inheritance, we can pass either FactoryEnum or ClothesFactory as the return type
enum FactoryEnum implements ClothesFactory {
    INSTANCE;       // Directly use enum for immutable one and only one instance

    @Override
    public Clothes createClothes(String type, String fabric, String brand, String color, Object... additionalParams) {
        if (type == null || fabric == null || brand == null || color == null) {
            throw new IllegalArgumentException("Type, fabric, brand, and color cannot be null");
        }
        switch (type.toLowerCase()) {
            case "shirt" -> {
                return new Shirt(fabric, brand, color);
            }
            case "hoodie" -> {
                boolean hasCap = additionalParams.length > 0 ? (boolean)additionalParams[0] : false;
                return new Hoodie(fabric, brand, color, hasCap);
            }
            case "blazer" -> {
                boolean isUniform = additionalParams.length > 0 ? (boolean)additionalParams[0] : false;
                return new Blazer(fabric, brand, color, isUniform);
            }
                
            default -> throw new IllegalArgumentException("Unknown clothes type: " + type);
        }
    }

    public static ClothesFactory getInstance() {
        return INSTANCE;
    }
}
