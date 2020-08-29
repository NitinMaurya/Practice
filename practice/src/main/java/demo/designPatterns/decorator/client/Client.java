package demo.designPatterns.decorator.client;

import demo.designPatterns.decorator.Coffee;
import demo.designPatterns.decorator.Espresso;
import demo.designPatterns.decorator.Latte;
import demo.designPatterns.decorator.MochaDecorator;
import demo.designPatterns.decorator.WhippedCreamDecorator;

public class Client {
    public static void main(String[] args) {
        Coffee coffeeA = new MochaDecorator(new Espresso());
        System.out.println(coffeeA.description());
        System.out.println(coffeeA.cost());

        Coffee coffeeB = new WhippedCreamDecorator(new MochaDecorator(new Latte()));
        System.out.println(coffeeB.description());
        System.out.println(coffeeB.cost());
    }
}
