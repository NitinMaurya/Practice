package demo.designPatterns.decorator;

public class WhippedCreamDecorator extends CoffeeDecorator {

    public WhippedCreamDecorator(Coffee coffee){
        super(coffee);
    }

    @Override
    public String description() {
        return super.description() + " with Whipped Cream";
    }

    @Override
    public int cost() {
        return super.cost() + 2;
    }
}
