package practice.DSA.algorithms.matrixChainMultiplication;

import java.util.Arrays;

public class PalindromePartitioning {

  private static final String DESCRIPTION = """
      Palindrome Partitioning
      
      Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
      Determine the fewest cuts needed for palindrome partitioning of the given string.
      
      Example 1:
                                                                               
       Input: str = "ababbbabbababa"
       Output: 3
       Explaination: After 3 partitioning substrings
       are "a", "babbbab", "b", "ababa".
       
      Example 2:
       
       Input: str = "aaabba"
       Output: 1
       Explaination: The substrings after 1
       partitioning are "aa" and "abba".
            
            
            
      """;

  private static class Solution {

    public int solve(String S) {
      return solve(S, 0, S.length() - 1);
    }

    private int solve(String S, int i, int j) {
      if (i >= j || isPalindrome(S, i, j)) {
        return 0;
      } else {
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
          int leftAns = solve(S, i, k);
          int rightAns = solve(S, k+1, j);
          int tempAns = 1 + leftAns + rightAns;
          ans = Math.min(ans, tempAns);
        }
        return ans;
      }
    }

    private boolean isPalindrome(String s, int i, int j) {
      String subStr = s.substring(i, j + 1);
      return new StringBuilder(subStr).reverse().toString().equals(subStr);
    }
  }

  private static class MemoizedSolution {
    private static final int MAX_DIMENSION = 502;
    int[][] cache;

    {
      cache = new int[MAX_DIMENSION][MAX_DIMENSION];

      for (int i = 0; i < MAX_DIMENSION; i++) {
        Arrays.fill(cache[i], -1);
      }
    }

    public int solve(String S) {
      return solve(S, 0, S.length() - 1);
    }

    private int solve(String S, int i, int j) {
      if (i >= j) {
        return 0;
      } else if (cache[i][j] != -1){
        return cache[i][j];
      } else if (isPalindrome(S, i, j)) {
        return 0;
      } else {
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
          int leftAns = solve(S, i, k);
          int rightAns = solve(S, k+1, j);
          int tempAns = 1 + leftAns + rightAns;
          ans = Math.min(ans, tempAns);
        }
        return cache[i][j] = ans;
      }
    }

    private boolean isPalindrome(String s, int i, int j) {
      String subStr = s.substring(i, j + 1);
      return new StringBuilder(subStr).reverse().toString().equals(subStr);
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String S = "ababbbabbababa";
    System.out.printf("S=%s, Result=%d%n", S, solution.solve(S));

  }
}
