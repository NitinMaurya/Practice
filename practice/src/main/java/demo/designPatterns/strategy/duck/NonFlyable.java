package demo.designPatterns.strategy.duck;

public class NonFlyable implements FlyableStrategy {
    @Override
    public void fly() {
        System.out.println("Cannot Fly");
    }
}
