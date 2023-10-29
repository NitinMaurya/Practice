package practice.DSA.algorithms.matrixChainMultiplication;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ScrambledString {

  private static class RecursiveSolution {

    private static final Map<String, Boolean> CACHE = new HashMap<>();
    private static final BiFunction<String, String, String> GET_KEY = (a, b) -> a + " " + b;

    private boolean solve(String A, String B) {
      if (A.length() != B.length()) {
        return false;
      } else {
        return isScrambled(A, B);
      }
    }

    private boolean isScrambled(String a, String b) {
      boolean result = false;
      String key = GET_KEY.apply(a,b);
      if (CACHE.containsKey(key)) {
        return CACHE.get(key);
      } else if (a.equals(b)) {
        result = true;
      } else if (a.length() <= 1) {
        result =  false;
      } else {
        int len = a.length() - 1;
        for (int i = 1; i <= len; i++) {
          String aStart = a.substring(0, i);
          String aEnd = a.substring(i+1);
          String bStart = b.substring(0, i);
          String bEnd = b.substring(i+1);
          // System.out.printf(">> i = %d (aStart = %s, aEnd = %s) (bStart = %s, bEnd = %s) %n", i, aStart, aEnd, bStart, bEnd);

          boolean scrambledIfSwapped = solve(aStart, bEnd) && solve(aEnd, bStart);
          boolean scrambledIfNotSwapped = solve(aStart, bStart) && solve(aEnd, bEnd);

          if (scrambledIfSwapped || scrambledIfNotSwapped) {
            result = true;
            System.out.printf(">> i = %d (aStart = %s, aEnd = %s) (bStart = %s, bEnd = %s) %n", i, aStart, aEnd, bStart, bEnd);
            break;
          }
        }
      }
      CACHE.put(key, result);
      return result;
    }
  }

  public static void main(String[] args) {
    RecursiveSolution recursiveSolution = new RecursiveSolution();
    String A = "abbbcbaaccacaacc";
    String B = "acaaaccabcabcbcb";
    System.out.printf("Scrambled (%s, %s) = %s", A, B, recursiveSolution.solve(A, B));
  }
}
