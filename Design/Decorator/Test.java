package Decorator;

import Singleton.SingletonWriter;

public class Test {
    public static void main(String[] args) {
        Coffee coffee = new BaseCoffee();
        SingletonWriter.getInstance().printLine(coffee.makeCoffee());
        Coffee syrupedCoffee = new CoffeeSyrup(new CoffeeDecorator(new BaseCoffee()));
        SingletonWriter.getInstance().printLine(syrupedCoffee.makeCoffee());
        Coffee sugarCoffee = new CoffeeSugar(new CoffeeDecorator(new BaseCoffee()));
        SingletonWriter.getInstance().printLine(sugarCoffee.makeCoffee());
    }
}
