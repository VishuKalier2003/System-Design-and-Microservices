package Decorator;

public class CoffeeDecorator implements Coffee {

    // The coffee interface wrapped in the Decorator class
    protected Coffee specialCoffee;

    public CoffeeDecorator(Coffee baseCoffee) {
        this.specialCoffee = baseCoffee;
    }

    @Override
    public String makeCoffee() {
        return "This is a coffee decorator...\n";
    }
}
