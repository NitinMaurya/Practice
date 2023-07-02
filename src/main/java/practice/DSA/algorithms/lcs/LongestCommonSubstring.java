package practice.DSA.algorithms.lcs;

public class LongestCommonSubstring {

  private final String description = """
      Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
            
      Examples :
            
      Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
      Output : 5
      Explanation:
      The longest common substring is “Geeks” and is of length 5.
            
      Input : X = “abcdxyz”, y = “xyzabcd”
      Output : 4
      Explanation:
      The longest common substring is “abcd” and is of length 4.
            
      """;

  private static class RecursiveSolution {

    public int solve(String X, String Y) {
      return longestCommonSubstring(X, Y, X.length() - 1, Y.length() - 1, 0);
    }

    public int longestCommonSubstring(String X, String Y, int m, int n, int len) {
      if (m < 0 || n < 0) {
        return len;
      }
      if (X.charAt(m) == Y.charAt(n)) {
        return longestCommonSubstring(X, Y, m - 1, n - 1, len + 1);
      } else {
        int length = Math.max(longestCommonSubstring(X, Y, m - 1, n, 0), longestCommonSubstring(X, Y, m, n - 1, 0));
        return Math.max(len, length);
      }
    }
  }

  private static class DPSolution {

    public int solve(String X, String Y) {
      return longestCommonSubstring(X, Y);
    }

    private int longestCommonSubstring(String X, String Y) {
      int[][] t = new int[X.length() + 1][Y.length() + 1];

      for (int i = 0; i < X.length() + 1; i++) {
        for (int j = 0; j < Y.length() + 1; j++) {
          if (i == 0 || j == 0) {
            t[i][j] = 0;
          }
        }
      }

      int maxLength = 0;

      for (int i = 1; i < X.length() + 1; i++) {
        for (int j = 1; j < Y.length() + 1; j++) {
          if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            t[i][j] = 1 + t[i-1][j-1];
            maxLength = Math.max(maxLength, t[i][j]);
          } else {
            t[i][j] = 0;
          }
        }
      }
      return maxLength;
    }
  }

  public static void main(String[] args) {
    String X = "GeeksforGeeks";
    String Y = "GeeksQuiz";  // Output : 5


    System.out.println(">>>>>>>>>>   test case 1     <<<<<<<<<");
    RecursiveSolution recursiveSolution = new RecursiveSolution();
    System.out.println("X=" + X + "   Y=" + Y);
    int result = recursiveSolution.solve(X,Y);
    System.out.println("Recursive: " + result);
    assert result == 5;

    DPSolution dpSolution = new DPSolution();
    System.out.println("X=" + X + "   Y=" + Y);
    result = dpSolution.solve(X,Y);

    System.out.println("DP: " + result);
    assert result == 5;

    System.out.println();


    // Test case 2
    System.out.println(">>>>>>>>>>   test case 2     <<<<<<<<<");

    X = "abcdxyz";
    Y = "xyzabcd";  // Output : 4

    System.out.println("X=" + X + "   Y=" + Y);
    result = recursiveSolution.solve(X,Y);
    System.out.println("Recursive: " + result);
    assert result == 4;

    System.out.println("X=" + X + "   Y=" + Y);
    result = dpSolution.solve(X,Y);
    System.out.println("DP: " + result);
    assert result == 4;

    System.out.println();


    // Test case 3
    System.out.println(">>>>>>>>>>   test case 3     <<<<<<<<<");

    X = "ABCDGH";
    Y = "ACDGHR";  // Output : 4

    System.out.println("X=" + X + "   Y=" + Y);
    result = recursiveSolution.solve(X,Y);
    System.out.println("Recursive: " + result);
    assert result == 4;

    System.out.println("X=" + X + "   Y=" + Y);
    result = dpSolution.solve(X,Y);
    System.out.println("DP: " + result);
    assert result == 4;

    System.out.println();

  }
}
