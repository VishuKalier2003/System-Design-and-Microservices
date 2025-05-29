package Decorator;

public class CoffeeSugar extends CoffeeDecorator {

    public CoffeeSugar(Coffee decorator) {
        super(decorator);
    }

    @Override
    public String makeCoffee() {
        return specialCoffee.makeCoffee() + addSugar();
    }

    public String addSugar() {
        return " with sugar added !!\n";
    }
}
