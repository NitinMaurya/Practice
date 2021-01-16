package practice.DSA.leetcode.datewise;

public class Jan_01_21 {
    public boolean canFormArray(int[] arr, int[][] p) {
        for (int i = 0; i < p.length; i++) {
            if (!canFit(arr, p[i])) {
                return false;
            }
        }
        return true;
    }


    public boolean canFit(int[] arr, int[] p) {
        int i = 0, j = 0;
        while (i < arr.length && j < p.length) {
            if (arr[i] == p[j]) {
                i++;
                j++;

                if (j == p.length) {
                    return true;
                }
            } else {
                i++;
                j = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean result = new Jan_01_21().canFormArray(
                new int[] {
                        1,2,3
                },
                new int[][]{
                        {2},
                        {1,3}
                }
        );
        System.out.println(result);
    }
}
