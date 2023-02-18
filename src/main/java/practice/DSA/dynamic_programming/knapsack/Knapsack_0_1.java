package practice.DSA.dynamic_programming.knapsack;

import java.util.Arrays;
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

    Knapsack_Recursive knapsackRecursive = new Knapsack_Recursive();
    Knapsack_DP knapsack_dp = new Knapsack_DP();
    int maxProfitByRecursive = knapsackRecursive.calculate(items, capacity, items.size() - 1 );
    int maxProfitByDP = knapsackRecursive.calculate(items, capacity, items.size() - 1 );

    System.out.println(maxProfitByRecursive);
    System.out.println(maxProfitByDP);
  }

}

record Item(int weight, int value) { }

class Knapsack_Recursive {

  public int calculate(List<Item> items, int capacity, int index) {
    if (index == 0 || capacity <= 0) {
      return 0;
    }
    int currentWeight = items.get(index).weight();
    int currentValue = items.get(index).value();
    if (currentWeight <= capacity) {
      return Math.max(
          currentValue + calculate(items, capacity - currentWeight, index - 1), // include item and reduce capacity
          calculate(items, capacity, index - 1) // dont include item
      );
    } else {
      return calculate(items, capacity, index - 1); // dont include item
    }
  }
}

class Knapsack_Memoized {
  int[][] memo;

  {
    memo = new int [1002][1002];

    // Fill each row with -1.
    for (int[] row : memo)
      Arrays.fill(row, -1);
  }



  public int calculate(List<Item> items, int capacity, int index) {
    if (index == 0 || capacity <= 0) {
      return 0;
    }
    if (memo[index][capacity] != -1) {
      return memo[index][capacity];
    }
    int currentWeight = items.get(index).weight();
    int currentValue = items.get(index).value();
    if (currentWeight <= capacity) {
      return memo[index][capacity] = Math.max(
          currentValue + calculate(items, capacity - currentWeight, index - 1), // include item and reduce capacity
          calculate(items, capacity, index - 1) // dont include item
      );
    } else {
      return memo[index][capacity] = calculate(items, capacity, index - 1); // dont include item
    }
  }
}

class Knapsack_DP {

  public int calculate(List<Item> items, int capacity, int index) {
    if (index == 0 || capacity <= 0) {
      return 0;
    }
    int[][] dp = new int[index+1][capacity + 1];

    for (int n = 0; n < 1; n++) {
      for (int w = 0; w < 1; w++) {
        dp[n][w] = 0;
      }
    }

    for (int n = 1; n <= index; n++) {
      for (int w = 1; w <= capacity; w++) {
        int currentWeight = items.get(n-1).weight();
        int currentValue = items.get(n-1).value();
        if (currentWeight <= w) {
          dp[n][w] = Math.max(
              currentValue + dp[n-1][w - currentWeight],
              dp[n-1][w]
          );
        } else {
          dp[n][w] = dp[n-1][w];
        }
      }
    }
    return dp[index][capacity];
  }
}

