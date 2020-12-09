package demo.designPatterns.strategy.duck;

public class LoudQuackable implements QuackableStrategy {
    @Override
    public void quack() {
        System.out.println("Quacking Loud");
    }
}
