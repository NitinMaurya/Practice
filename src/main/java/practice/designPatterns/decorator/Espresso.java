package practice.designPatterns.decorator;

public class Espresso implements Coffee {

    @Override
    public String description() {
        return "Order: Espresso";
    }

    @Override
    public int cost() {
        return 4;
    }
}
