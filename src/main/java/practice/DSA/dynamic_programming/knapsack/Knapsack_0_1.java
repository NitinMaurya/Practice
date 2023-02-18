package practice.DSA.dynamic_programming.knapsack;

import java.util.List;

public class Knapsack_0_1 {
  public static void main(String[] args) {

    String description = """
        Given a list of items having two properties ie weight and value, and a bag with capacity C,
        you need to put items in the bag but the sum of weight of items cannot exceed the bag's capacity.
        return the maximum value of the bag.
               
        """;
    List<Item> items = List.of(
        new Item(4,1),
        new Item(5,2),
        new Item(1,3)
    );

    int capacity = 4;

    Knapsack knapsack = new Knapsack();
    int maxProfit = knapsack.calculate(items, capacity, items.size() - 1 );

    System.out.println(maxProfit);
  }

}

record Item(int weight, int value) { }

class Knapsack {

  public int calculate(List<Item> items, int capacity, int index) {
    if (index < 0 || capacity == 0) {
      return 0;
    }
    int currentWeight = items.get(index).weight();
    int currentValue = items.get(index).value();
    if (currentWeight <= capacity) {
      return currentValue + Math.max(
          calculate(items, capacity - currentWeight, index - 1),
          calculate(items, capacity, index - 1)
      );
    } else {
      return calculate(items, capacity, index - 1);
    }
  }
}

