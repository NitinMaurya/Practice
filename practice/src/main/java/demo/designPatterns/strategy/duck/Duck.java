package demo.designPatterns.strategy.duck;

public class Duck {
    private QuackableStrategy quackStrategy;
    private FlyableStrategy flyStrategy;

    public Duck(QuackableStrategy quackStrategy,
                FlyableStrategy flyStrategy){
        this.quackStrategy = quackStrategy;
        this.flyStrategy = flyStrategy;
    }

    public void fly(){
        this.flyStrategy.fly();
    }

    public void quack(){
        this.quackStrategy.quack();
    }
}
