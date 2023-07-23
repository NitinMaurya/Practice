package practice.DSA.algorithms.matrixChainMultiplication;

import java.util.Arrays;

public class MatrixChainMultiplication {

  private static class RecursiveSolution {

    public int solve(int[] arr){
      return solve(arr, 1, arr.length - 1);
    }

    private int solve(int[] arr, int i, int j) {
      if (i >= j) {
        return 0;
      } else {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
          int leftCost = solve(arr, i, k);                    // Multiply     A X B
          int rightCost = solve(arr, k+1, j);              // Multiply     B X C
          int currentCost = arr[i-1] * arr[k] * arr[j];       // Multiply     A X C

          int totalCost = leftCost + currentCost + rightCost;    // Total Multiplication cost

          min = Math.min(min, totalCost);
        }
        return min;
      }
    }
  }

  private static class MemoizedSolution {
    private static final Integer MAX_DIMENSION = 105;
    int[][] cache;

    {
      cache = new int[MAX_DIMENSION][MAX_DIMENSION];
      for (int i = 0; i < MAX_DIMENSION; i++) {
        Arrays.fill(cache[i], -1);
      }
    }

    public int solve(int[] arr){
      return solve(arr, 1, arr.length - 1);
    }

    private int solve(int[] arr, int i, int j) {
      if (i >= j) {
        return 0;
      } else if (cache[i][j] != -1) {
        return cache[i][j];
      } else {
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
          int leftCost = solve(arr, i, k);                    // Multiply     A X B
          int rightCost = solve(arr, k+1, j);              // Multiply     B X C
          int currentCost = arr[i-1] * arr[k] * arr[j];       // Multiply     A X C

          int totalCost = leftCost + currentCost + rightCost;    // Total Multiplication cost

          min = Math.min(min, totalCost);
        }
        return cache[i][j] = min;
      }
    }
  }

  public static void main(String[] args) {
    RecursiveSolution solution = new RecursiveSolution();
    int[] input = new int[]{40, 20, 30, 10, 30, 60};


    long start = System.currentTimeMillis();
    System.out.printf("Input = %s Output = %d%n", Arrays.toString(input), solution.solve(input));
    System.out.println("time taken ms= " + (System.currentTimeMillis() - start));


    start = System.currentTimeMillis();
    MemoizedSolution memoizedSolution = new MemoizedSolution();
    System.out.printf("Input = %s Output = %d%n", Arrays.toString(input), memoizedSolution.solve(input));
    System.out.println("time taken ms= " + (System.currentTimeMillis() - start));
  }
}
