package practice.DSA.practice;

import java.util.HashMap;
import java.util.Map;

/*  Find the maximum contiguous subArray with equal no of zeroes and ones in a binary array
 *
 *   5
 *   1 0 1 0 1
 *   4
 *
 * */
public class MaximumContiguousBinaryArray {
    private static int contiguousArray(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count = count + ((array[i] == 1) ? 1 : -1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int result = contiguousArray(new int[]{1, 0, 1, 0, 1});
        System.out.println(result);
    }
}
