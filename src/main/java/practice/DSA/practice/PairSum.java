package practice.DSA.practice;

import java.util.Arrays;

public class PairSum {

    public static int numPairsDivisible(int[] array, int k) {
        int pairs = 0;
        int[] count = new int[k + 1];
        Arrays.fill(count, 0);
        for (int j : array) {
            count[j % k]++;
        }
        pairs += count[0] * (count[0] - 1) / 2;

        for (int i = 1 ; i < k/2 ; i++) {
            pairs += count[i] * count[k - i];
        }

        if (k % 2 == 0) {
            pairs += count[k/2] * (count[k/2] - 1) / 2;
        }

        return pairs;
    }

    public static void main(String[] args) {
        int[] input = new int[]{};
        int result = numPairsDivisible(input, 60);
        System.out.println(result);
    }
}
