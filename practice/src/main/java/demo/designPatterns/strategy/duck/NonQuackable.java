package demo.designPatterns.strategy.duck;

public class NonQuackable implements QuackableStrategy {
    @Override
    public void quack() {
        System.out.println("Cannot Quack");
    }
}
