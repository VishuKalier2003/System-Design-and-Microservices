class FactorySingleton {

    private FactorySingleton() {}       // private default constructor

    protected static class FactoryLoader implements ClothesFactory {
        // Immutable and static instance (singleton pattern)
        private final static FactoryLoader INSTANCE = new FactoryLoader();      // Immutable since source of truth (private, static and final)

        private FactoryLoader() {}      // private default constructor

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
                    boolean hasCap = additionalParams.length > 0 ? (boolean) additionalParams[0] : false;
                    return new Hoodie(fabric, brand, color, hasCap);
                }
                case "blazer" -> {
                    boolean isUniform = additionalParams.length > 0 ? (boolean) additionalParams[0] : false;
                    return new Blazer(fabric, brand, color, isUniform);
                }
                default -> throw new IllegalArgumentException("Unknown clothes type: " + type);
            }
        }
    }

    // Exposes only the interface via public API, the Factory class remains concrete and hidden (encapsulated)
    public static ClothesFactory getInstance() {
        return FactoryLoader.INSTANCE;      // Client codes to abstraction not implementation
    }
}
