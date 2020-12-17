package practice.DSA;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-sum, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new FourSumII().fourSumCount(
                new int[]{1, 2},
                new int[]{-2, -1},
                new int[]{-1, 2 },
                new int[]{0,2}
        );
        System.out.println("RESULT : " + res);
    }
}
