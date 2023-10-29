package practice.DSA.algorithms.dp.knapsack;

import java.util.Arrays;

/*
*  Given an array arr[] of N non-negative integers representing the height of blocks. If width of each block is 1,
*  compute how much water can be trapped between the blocks during the rainy season.

    Example 1:

    Input:
    N = 6
    arr[] = {3,0,0,2,0,4}
    Output:
    10

    Reference: https://www.interviewbit.com/blog/trapping-rain-water/

    *
    * Solution:
    * For the current building, look for the highest building on the left side and the highest building on the right side
    * the water collected for the current building is Minimum of highest on the left and highest on the right minus current building height.
    *
    *
    * Optimized using two pointer approach
    *
    * Algorithm:
        Initialise two pointers left = 0 and right = N – 1 and res = 0.
        Initialise two variables left_max = 0 and right_max = 0, denoting the maximum height on the left and maximum height on the right.
        Traverse the array, i.e. while(left <= right)
        If A[left] < A[right] and left_max > A[left]
            Then, add left_max – A[left] to res
        Else if left_max < A[left]
            Update left_max to A[left]
        Increment left pointer

        Similarly, if If A[left] > A[right] and right_max > A[right]
            Then, add right_max – A[right] to res
        Else if right_max < A[right]
            Update right_max to A[right]
        Increment right pointer
        Print res
*
* */
public class TrappingRainWater {

  static class Solution {
    public int solve(int[] arr) {


      int[] leftMax = new int[arr.length];
      leftMax[0] = arr[0];
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] > leftMax[i-1]) {
          leftMax[i] = arr[i];
        } else {
          leftMax[i] = leftMax[i-1];
        }
      }
      System.out.println("LMAX=" + Arrays.toString(leftMax));

      int[] rightMax = new int[arr.length];
      rightMax[arr.length - 1] = arr[arr.length - 1 ];
      for (int i = arr.length - 2 ; i >= 0 ; i--) {
        if (arr[i] > rightMax[i+1]) {
          rightMax[i] = arr[i];
        } else {
          rightMax[i] = rightMax[i+1];
        }
      }
      System.out.println("RMAX=" + Arrays.toString(rightMax));

      int result = 0;
      for (int i = 0; i < arr.length; i++) {
        result += Math.min(leftMax[i], rightMax[i]) - arr[i];
      }
      return result;
    }

  }

  public static void main(String[] args) {
    int[] input1 = new int[] {7,4,0,9};
    Solution s = new Solution();
    System.out.println("Input=" + Arrays.toString(input1) + " Output: " + s.solve(input1));
  }
}
