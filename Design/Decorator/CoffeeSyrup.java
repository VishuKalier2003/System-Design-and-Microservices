package Decorator;

public class CoffeeSyrup extends CoffeeDecorator {

    public CoffeeSyrup(Coffee interfaceCoffee) {
        super(interfaceCoffee);
    }

    @Override
    public String makeCoffee() {
        return specialCoffee.makeCoffee() + addSyrup();
    }

    public String addSyrup() {
        return "syrup added \n";
    }
}
