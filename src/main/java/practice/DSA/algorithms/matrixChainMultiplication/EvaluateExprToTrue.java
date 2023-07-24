package practice.DSA.algorithms.matrixChainMultiplication;

public class EvaluateExprToTrue {

  private static class Solution {

    private int countWays(String S){
      return solve(S, 0, S.length() - 1, true);
    }

    private int solve(String X, int i, int j, boolean bool) {
      if (i > j) {
        return 0;
      } else  if (i == j) {
        if (Boolean.TRUE.equals(bool)) {
          return X.charAt(i) == 'T' ? 1 : 0;
        } else {
          return X.charAt(i) == 'F' ? 1 : 0;
        }
      } else {
        int ways = 0;
        for (int k = i+1; k < j; k+=2) {
          int leftTrue = solve(X, i, k-1, true);
          int leftFalse = solve(X, i, k-1, false);
          int rightTrue = solve(X, k+1, j, true);
          int rightFalse = solve(X, k+1, j, false);

          if (X.charAt(k) == '|') {
            if (Boolean.TRUE.equals(bool)) {
              ways = ways +
                     (leftTrue * rightTrue) +
                     (leftTrue * rightFalse) +
                     (leftFalse * rightTrue);
            } else {
              ways = ways +
                     (leftFalse * rightFalse);
            }
          } else if (X.charAt(k) == '&') {
            if (Boolean.TRUE.equals(bool)) {
              ways = ways +
                     (leftTrue * rightTrue);
            } else {
              ways = ways +
                     (leftFalse * rightFalse) +
                     (leftTrue * rightFalse) +
                     (leftFalse * rightTrue);
            }
          } else {
            if (Boolean.TRUE.equals(bool)) {
              ways = ways +
                     (leftTrue * rightFalse) +
                     (leftFalse * rightTrue);
            } else {
              ways = ways +
                     (leftTrue * rightTrue) +
                     (leftFalse * rightFalse);
            }
          }
        }
        return ways;
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String S = "T|T&F^T";
    System.out.printf("S=%s  ---  # of ways=%d %n", S, solution.countWays(S));
  }
}
