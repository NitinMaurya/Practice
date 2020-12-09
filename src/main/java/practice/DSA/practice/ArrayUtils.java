package practice.DSA.practice;

import java.util.Scanner;

public class ArrayUtils {

    private ArrayUtils () {}

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +  " ");
        }
        System.out.println(" ");
    }

    public static int[] input() {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            ArrayUtils.swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static int binarySearch(int[] array, int element) {
        int low = 0;
        int high = array.length;
        return binarySearch(array, low, high, element);
    }

    public static int binarySearch(int[] array, int start, int end, int element) {
        if (!isSorted(array)) {
            throw new UnsupportedOperationException("Array is not sorted for binary search.");
        }
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if (element == array[mid]) {
                return mid;
            } else if (element > array[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] > array[i]) {
                return false;
            }
        }
        return true;
    }
}
