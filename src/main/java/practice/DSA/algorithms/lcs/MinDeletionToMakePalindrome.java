package practice.DSA.algorithms.lcs;

// Solution passed on GFG
// Time Complexity: O(m*n).
// Auxiliary Space: O(m*n)
public class MinDeletionToMakePalindrome {

  private static final String DESCRIPTION = """   
            
      link: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions4610/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
            
      Given a string 'str' of size ‘n’. The task is to remove or delete the minimum number of characters from the string so that the resultant string is a palindrome. Find the minimum numbers of characters we need to remove.
      Note: The order of characters should be maintained.
       
       Example 1:
       
       Input: n = 7, str = "aebcbda"
       Output: 2
       Explanation: We'll remove 'e' and
       'd' and the string become "abcba".
                                                     
      
      Solution:  str.length() - LPS(X);
      """;

  static class Solution {
    public int solve(String X) {
      return X.length() - longestPalindromicSubsequence(X);
    }

    private int longestPalindromicSubsequence(String X) {
      return longestCommonSubsequence(X, new StringBuilder(X).reverse().toString());
    }

    private int longestCommonSubsequence(String X, String Y) {
      int[][] t = new int[X.length() + 1][Y.length() + 1];

      for (int i = 0; i < X.length() + 1; i++) {
        for (int j = 0; j < Y.length() + 1; j++) {
          if(i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      for (int i = 1; i < X.length() + 1; i++) {
        for (int j = 1; j < Y.length() + 1; j++) {
          if(X.charAt(i - 1) == Y.charAt(j - 1)) {
            t[i][j] = 1 + t[i-1][j-1];
          } else {
            t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
          }
        }
      }

      return t[X.length()][Y.length()];
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String X = "aebcbda";

    System.out.printf("Min number of Deletion to make X=%s a palindrome:  %d%n", X, solution.solve(X));
  }
}
