package practice.DSA.algorithms.lcs;

// Solution passed on GFG
// Time Complexity: O(m*n).
// Auxiliary Space: O(m*n)
public class ShortestCommonSuperSequence {

  private static final String DESCRIPTION = """     
      Given two strings X and Y of lengths m and n respectively, find the length of the smallest string which has both, X and Y as its sub-sequences.
      Note: X and Y can have both uppercase and lowercase letters.
            
      Example 1
            
      Input:
      X = abcd, Y = xycd
      Output: 6
      Explanation: Shortest Common Supersequence
      would be abxycd which is of length 6 and
      has both the strings as its subsequences.
      """;

  static class Solution {
    public int solve(String X, String Y) {
      return (X.length() + Y.length()) - longestCommonSubsequence(X,Y);
    }

    private int longestCommonSubsequence(String x, String y) {
      int[][] t = new int[x.length() + 1][y.length() + 1];

      for (int i = 0; i < x.length() + 1; i++) {
        for (int j = 0; j < y.length() + 1; j++) {
          if (i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      for (int i = 1; i < x.length() + 1; i++) {
        for (int j = 1; j < y.length() + 1; j++) {
          if (x.charAt(i - 1) == y.charAt(j - 1)) {
            t[i][j] = 1 + t[i-1][j-1];
          } else {
            t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
          }
        }
      }

      return t[x.length()][y.length()];
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String X = "abcd";
    String Y = "xycd";

    System.out.printf("Length of Shortest Common SuperSequence between X=%s Y=%s:  %d%n", X , Y, solution.solve(X , Y));
  }
}
