package demo.designPatterns.strategy.duck.client;

import demo.designPatterns.strategy.duck.CloudFlyable;
import demo.designPatterns.strategy.duck.Duck;
import demo.designPatterns.strategy.duck.LoudQuackable;
import demo.designPatterns.strategy.duck.NonFlyable;
import demo.designPatterns.strategy.duck.NonQuackable;

public class Client {
    public static void main(String[] args) {
        print(new Duck(new LoudQuackable(), new CloudFlyable()));
        print(new Duck(new NonQuackable(), new NonFlyable()));
    }

    private static void print(Duck duck) {
        duck.quack();
        duck.fly();
    }
}
