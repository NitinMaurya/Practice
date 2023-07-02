package practice.DSA.algorithms.dp.knapsack.unbounded;

import java.util.Arrays;

public class RodCuttingProblem {

  public static class Solution {

    // passed but got TLE
    public int cutRodRecursive(int[] prices, int lengthOfRod, int i) {
      if (i < 0) {
        return 0;
      } else {
        if ((i + 1) <= lengthOfRod) {
          return Math.max(
              prices[i] + cutRodRecursive(prices, lengthOfRod - (i + 1), i),
              cutRodRecursive(prices, lengthOfRod, i - 1)
          );
        } else {
          return cutRodRecursive(prices, lengthOfRod, i - 1);
        }
      }
    }


    public int cutRodUsingKnapsackDP(int[] prices, int L) {
      int[][] t = new int[prices.length + 1][L + 1];

      for (int i = 0; i < prices.length + 1; i++) {
        for (int j = 0; j < L + 1; j++) {
          if (i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      for (int i = 1; i < prices.length + 1; i++) {
        for (int j = 1; j < L + 1; j++) {
          if (i <= j) {
            t[i][j] = Math.max(
                prices[i - 1] + t[i][j - i],
                t[i-1][j]
            );
          } else {
            t[i][j] = t[i-1][j];
          }
        }
      }

      return t[prices.length][L];
    }




    public void solve() {
      // test case 1
      var prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
      var lengthOfRod = 8;
      print(prices);
      System.out.println("Recursively:" + cutRodRecursive(prices, lengthOfRod, prices.length - 1));
      System.out.println("DP:" + cutRodUsingKnapsackDP(prices, lengthOfRod));

      // test case 2
      prices = new int[]{3, 5, 8, 9, 10, 17, 17, 20};
      lengthOfRod = 8;
      print(prices);
      System.out.println("Recursively:" + cutRodRecursive(prices, lengthOfRod, prices.length - 1));
      System.out.println("DP:" + cutRodUsingKnapsackDP(prices, lengthOfRod));
    }

    private void print(int[] array) {
      Arrays.stream(array).forEach(el -> System.out.print(el + " "));
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.solve();
  }
}
