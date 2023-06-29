package practice.DSA.algorithms.dp.knapsack;

public class CountOfSubsetsWithAGivenSum {

  static class Solution {

    public int count(int[] arr, int sum) {
      int[][] t = new int[arr.length + 1][sum + 1];

      for (int i = 0; i < arr.length + 1; i++) {
        for (int j = 0; j < sum + 1; j++) {
          if (i == 0) {
            t[i][j] = 0;
          }
          if (j == 0) {
            t[i][j] = 1;
          }
        }
      }

      for (int i = 1; i < arr.length + 1; i++) {
        for (int j = 1; j < sum + 1; j++) {
          if (arr[i - 1] <= j) {
            t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
            // current = include the current element  + exclude and take the previous one
          } else {
            t[i][j] = t[i - 1][j];
          }
        }
      }

      return t[arr.length][sum];
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    int[] arr = new int[]{2, 3, 5, 6, 8, 10};
    int sum = 10;
    System.out.println(solution.count(arr, sum));

  }
}

