package practice.DSA.algorithms.dp.knapsack;

import java.util.Arrays;

public class SubsetSum {

  static class Solution {

    public boolean solve(int[] arr, int N, int sum) {
      boolean[][] dp = new boolean[N + 1][sum + 1];

      for (int n = 0; n < 1; n++) {
        for (int s = 0; s < 1; s++) {
          if (n == 0) {
            dp[n][s] = false;
          }
          if (s == 0) {
            dp[n][s] = true;
          }
        }
      }

      for (int n = 1; n <= N; n++) {
        for (int s = 1; s <= sum; s++) {
          if (arr[n - 1] <= s) {
            dp[n][s] = dp[n - 1][s - arr[n - 1]] || dp[n - 1][s];
          } else {
            dp[n][s] = dp[n - 1][s];
          }
        }
      }

      return dp[N][sum];
    }

  }


  public static void main(String[] args) {
    String description = """
        Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with
         sum equal to given sum.
         
         Input:
         N = 6
         arr[] = {3, 34, 4, 12, 5, 2}
         sum = 9
         
         Output: 1
         
         Explanation: Here there exists a subset with
         sum = 9, 4+3+2 = 9.
        """;

    int[] arr = new int[]{3, 34, 4, 12, 5, 2};
    int sum = 9;

    boolean result = new Solution().solve(arr, arr.length, sum);

    System.out.println("arr: " + Arrays.toString(arr) + " sum: " + sum + " output: " + result);

    sum = 30;
    result = new Solution().solve(arr, arr.length, sum);

    System.out.println("arr: " + Arrays.toString(arr) + " sum: " + sum + " output: " + result);
  }
}
