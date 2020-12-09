package practice.designPatterns.decorator;

public class Latte implements Coffee {
    @Override
    public String description() {
        return "Order: Latte";
    }

    @Override
    public int cost() {
        return 5;
    }
}
