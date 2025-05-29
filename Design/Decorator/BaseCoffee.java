package Decorator;

public class BaseCoffee implements Coffee {

    @Override
    public String makeCoffee() {
        return "Made a coffee...\n";
    }
}
