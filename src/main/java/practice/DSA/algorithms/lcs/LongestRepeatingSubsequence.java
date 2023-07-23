package practice.DSA.algorithms.lcs;

public class LongestRepeatingSubsequence {

  static class Solution {
    public String solve(String X) {
      return longestRepeatingSubsequence(X, X);
    }

    public String longestRepeatingSubsequence(String X, String Y) {
      int[][] t = new int[X.length() + 1][Y.length() + 1];

      for (int i = 0; i < X.length() + 1; i++) {
        for (int j = 0; j < Y.length() + 1; j++) {
          if(i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      StringBuilder result = new StringBuilder();

      for (int i = 1; i < X.length() + 1; i++) {
        for (int j = 1; j < Y.length() + 1; j++) {
          if(X.charAt(i - 1) == Y.charAt(j - 1) && i != j) {
            t[i][j] = 1 + t[i-1][j-1];
            result.append(X.charAt(i - 1));
          } else {

            if (t[i-1][j] > t[i][j-1]) {
              t[i][j] = t[i-1][j];
              result.append(X.charAt(i - 1));
            } else {
              t[i][j] = t[i][j-1];
              result.append(Y.charAt(j - 1));
            }
          }
        }
      }

      return result.reverse().toString();
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String X = "axxzxy";

    System.out.printf("Longest Repeating Subsequence for X=%s: %s%n", X, solution.solve(X));

    X = "AABEBCDD";

    System.out.printf("Longest Repeating Subsequence for X=%s: %s%n", X, solution.solve(X));

  }
}
