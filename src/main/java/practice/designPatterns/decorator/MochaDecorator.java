package practice.designPatterns.decorator;

public class MochaDecorator extends CoffeeDecorator {

    public MochaDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String description() {
        return super.description() + " with Mocha";
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
