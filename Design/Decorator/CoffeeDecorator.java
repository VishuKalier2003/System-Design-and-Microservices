package Decorator;

public class CoffeeDecorator implements Coffee {

    @Override
    public String makeCoffee() {
        return "This is a coffee decorator...\n";
    }
}
