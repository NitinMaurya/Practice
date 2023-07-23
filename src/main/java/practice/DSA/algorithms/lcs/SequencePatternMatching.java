package practice.DSA.algorithms.lcs;

public class SequencePatternMatching {

  private static final String DESCRIPTION = """
      link: https://leetcode.com/problems/is-subsequence/description/
      
      Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
            
      A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
            
      Example 1:
            
      Input: s = "abc", t = "ahbgdc"
      Output: true
      Example 2:
            
      Input: s = "axc", t = "ahbgdc"
      Output: false
            
      """;



  public static class Solution {

    public boolean solve(String S, String T) {
      return S.length() == longestCommonSubsequence(S,T);
    }

    private int longestCommonSubsequence(String X, String Y) {
      int[][] t = new int[X.length() + 1][Y.length() + 1];


      for (int i = 0; i < X.length() + 1; i++) {
        for (int j = 0; j < Y.length() + 1; j++) {
          if (i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      for (int i = 1; i < X.length() + 1; i++) {
        for (int j = 1; j < Y.length() + 1; j++) {
          if (X.charAt(i - 1) == Y.charAt(j - 1) ) {
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
    String S = "abc";
    String T = "ahbgdc";

    System.out.printf("S=%s T=%s, Result=%s %n", S, T, solution.solve(S, T));
  }
}
