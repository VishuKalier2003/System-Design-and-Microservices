// Interface defined for abstraction layer
interface ClothesFactory {
    // All the properties that need to be added or removed can be placed here
    public Clothes createClothes(String type, String fabric, String brand, String color, Object... params);

    static ClothesFactory getInstance() {
        return FactoryEnum.INSTANCE;
    }
}