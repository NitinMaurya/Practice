package practice.designPatterns.decorator.client;

import practice.designPatterns.decorator.Coffee;
import practice.designPatterns.decorator.Espresso;
import practice.designPatterns.decorator.Latte;
import practice.designPatterns.decorator.MochaDecorator;
import practice.designPatterns.decorator.WhippedCreamDecorator;

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
