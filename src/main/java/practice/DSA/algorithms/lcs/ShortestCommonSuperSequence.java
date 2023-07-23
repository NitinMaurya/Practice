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




    /*

          Given two strings str1 and str2, return the shortest string that has both str1 and str2 as subsequences. If there are multiple valid strings, return any of them.

          A string s is a subsequence of string t if deleting some number of characters from t (possibly 0) results in the string s.



          Example 1:

          Input: str1 = "abac", str2 = "cab"
          Output: "cabac"
          Explanation:
          str1 = "abac" is a subsequence of "cabac" because we can delete the first "c".
          str2 = "cab" is a subsequence of "cabac" because we can delete the last "ac".
          The answer provided is the shortest such string that satisfies these properties.

          // Solution passed on Leetcode
          // Time Complexity: O(m*n).
          // Auxiliary Space: O(m*n)
          // link: https://leetcode.com/problems/shortest-common-supersequence/description/

     */
    public String print(String X, String Y) {
      int[][] t = longestCommonSubsequenceBuild(X, Y);
      int i = X.length();
      int j = Y.length();

      StringBuilder result = new StringBuilder();
       while (i > 0 && j > 0) {
         if (X.charAt(i - 1) == Y.charAt(j - 1)) {
           result.append(X.charAt(i - 1));
           i--;
           j--;
         } else {
           if (t[i - 1][j] > t[i][j - 1]) {
             result.append(X.charAt(i - 1));
             i--;
           } else {
             result.append(Y.charAt(j - 1));
             j--;
           }
         }
       }

       while(i > 0) {
         result.append(X.charAt(i - 1));
         i--;
       }

       while (j > 0) {
         result.append(Y.charAt(j - 1));
         j--;
       }

       return result.reverse().toString();
    }

    private int longestCommonSubsequence(String X, String Y) {
      int[][] t = longestCommonSubsequenceBuild(X, Y);
      return t[X.length()][Y.length()];
    }

    private int[][] longestCommonSubsequenceBuild(String x, String y) {
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

      return t;
    }

  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String X = "abcd";
    String Y = "xycd";

    System.out.printf("Length of Shortest Common SuperSequence between X=%s Y=%s:  %d Result: %s%n", X , Y, solution.solve(X , Y), solution.print(X , Y));

    X = "AGGTAB";
    Y = "GXTXAYB";

    System.out.printf("Length of Shortest Common SuperSequence between X=%s Y=%s:  %d Result: %s%n", X , Y, solution.solve(X , Y), solution.print(X , Y));
  }
}
