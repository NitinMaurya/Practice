package practice.DSA.algorithms.lcs;

// Solution passed on GFG
// Time Complexity: O(m*n).
// Auxiliary Space: O(m*n)
public class LongestPalindromicSubsequence {

  private static final String DESCRIPTION = """   
            
      link: https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab  
            
      Given a String, find the longest palindromic subsequence.
            
      Example 1:
            
      Input:
      S = "bbabcbcab"
      Output: 7
      Explanation: Subsequence "babcbab" is the
      longest subsequence which is also a palindrome.
      
      Solution: Find LCS between X and X.reverse();
      """;

  static class Solution {
    public int solve(String X) {
      return longestCommonSubsequence(X, new StringBuilder(X).reverse().toString());
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

    String X = "bbabcbcab";

    System.out.printf("Length of Longest Palindromic Subsequence for X=%s:  %d%n", X, solution.solve(X));
  }
}
