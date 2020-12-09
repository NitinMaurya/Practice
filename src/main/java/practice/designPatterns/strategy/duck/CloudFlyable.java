package practice.designPatterns.strategy.duck;

public class CloudFlyable implements FlyableStrategy {
    @Override
    public void fly() {
        System.out.println("Flying in cloud");
    }
}
