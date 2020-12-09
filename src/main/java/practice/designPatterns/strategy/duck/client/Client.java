package practice.designPatterns.strategy.duck.client;

import practice.designPatterns.strategy.duck.CloudFlyable;
import practice.designPatterns.strategy.duck.Duck;
import practice.designPatterns.strategy.duck.LoudQuackable;
import practice.designPatterns.strategy.duck.NonFlyable;
import practice.designPatterns.strategy.duck.NonQuackable;

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
