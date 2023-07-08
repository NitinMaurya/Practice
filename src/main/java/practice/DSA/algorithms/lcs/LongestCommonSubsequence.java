package practice.DSA.algorithms.lcs;

public class LongestCommonSubsequence {

  private final String description = """
      Given two strings, S1 and S2, the task is to find the length of the longest subsequence 
      present in both of the strings.
      
      Input: S1 = “AGGTAB”, S2 = “GXTXAYB”
      Output: 4
      Explanation: The longest subsequence which is present in both strings is “GTAB”.
      
      """;

  private static class RecursiveSolution {

    public int solve(String X, String Y) {
      return lcs(X, Y, X.length() - 1, Y.length() - 1);
    }

    public int lcs(String X, String Y, int m, int n) {
      if (m < 0 || n < 0) {
        return 0;
      }

      if (X.charAt(m) == Y.charAt(n)) {
        return 1 + lcs(X, Y, m - 1, n - 1);
      } else {
        return Math.max(
            lcs(X, Y, m - 1, n),
            lcs(X, Y, m, n - 1)
        );
      }
    }
  }

  public static class DPSolution {

    public int solve(String X, String Y) {
      int m = X.length();
      int n = Y.length();
      int[][] t = new int[m + 1][n + 1];

      for (int i = 0; i < m + 1; i++) {
        for (int j = 0; j < n + 1; j++) {
          if (i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
          if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            t[i][j] = 1 + t[i-1][j-1];
          } else {
            t[i][j] = Math.max(
                t[i][j-1],
                t[i-1][j]
            );
          }
        }
      }
      return t[m][n];
    }
  }

  static class PrintLongestCommonSubsequence {

    public void print(String X, String Y) {
      int m = X.length();
      int n = Y.length();
      int[][] t = new int[m+1][n+1];

      for (int i = 0; i < m + 1; i++) {
        for (int j = 0; j < n + 1; j++) {
          if (i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      for (int i = 1; i < m + 1; i++) {
        for (int j = 1; j < n + 1; j++) {
          if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            t[i][j] = 1 + t[i - 1][j - 1];
          } else {
            t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
          }
        }
      }
      StringBuilder result = new StringBuilder();

      while (m > 0 && n > 0) {
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
          result.append(X.charAt(m - 1));
          m--;
          n--;
        } else if (t[m - 1][n] > t[m][n - 1]){
          m--;
        } else {
          n--;
        }
      }

      System.out.println("Longest Common Subsequence: " + result.reverse());
    }
  }

  public static void main(String[] args) {
    String X = "AGGTAB";
    String Y = "GXTXAYB";   // output: 4


    RecursiveSolution recursiveSolution = new RecursiveSolution();
    int result = recursiveSolution.solve(X,Y);
    System.out.println("Recursive: " + result);

    DPSolution dpSolution = new DPSolution();
    result = dpSolution.solve(X,Y);
    System.out.println("DP: " + result);

    PrintLongestCommonSubsequence printLongestCommonSubsequence = new PrintLongestCommonSubsequence();
    printLongestCommonSubsequence.print(X, Y);

    printLongestCommonSubsequence.print("NITIN", "TANIYA");

  }
}
