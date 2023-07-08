package practice.DSA.algorithms.lcs;


// Solution Passed
// Time Complexity: O(m * n)
// Space Complexity: O(m * n)
public class MinOperationToTransformAtoB {

  private static final String DESCRIPTION = """
            
      link: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab      
            
      Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
            
      Example 1:
            
      Input: str1 = "heap", str2 = "pea"
      Output: 3
      
      Explanation: 2 deletions and 1 insertion
      p and h deleted from heap. Then, p is\s
      inserted at the beginning One thing to\s
      note, though p was required yet it was\s
      removed/deleted first from its position\s
      and then it is inserted to some other\s
      position. Thus, p contributes one to the\s
      deletion_count and one to the\s
      insertion_count.
            
      """;

  static class Solution {
    public int solve(String X, String Y) {
      int lcs = longestCommonSubsequence(X, Y);
      return (X.length() - lcs)  // deletions
             + (Y.length() - lcs);   // insertions
    }

    public int longestCommonSubsequence(String X, String Y) {
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
          if (X.charAt(i-1) == Y.charAt(j - 1)) {
            t[i][j] = 1 + t[i-1][j-1];
          } else {
            t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
          }
        }
      }

      return t[X.length()][Y.length()];
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();

    String X = "heap";
    String Y = "pea";

    System.out.printf("Min operations to transform X=%s to Y=%s: %d%n", X, Y, solution.solve(X, Y));
  }
}
