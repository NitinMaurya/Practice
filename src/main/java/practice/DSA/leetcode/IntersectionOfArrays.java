package practice.DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

// 1. sort both arrays, then merge and create intersections
//  O(M Log M) + O(N Log N) + O(min(M,N))

// 2. put smaller array counts into hashmap, and scan other array
//  O(min(M,N)) space, O(M+N) time

public class IntersectionOfArrays {
    public static int[] intersectUsingMergeSort(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int M = nums1.length, N = nums2.length;
        int i = 0, j = 0;

        List<Integer> result = new ArrayList<>();

        while (i < M && j < N) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++; j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] intersectUsingHashMap(int[] first, int[] second) {
        boolean isFirstSmaller = first.length < second.length;

        Map<Integer, Integer> map = ArrayUtils.countMap(isFirstSmaller ? first : second);

        int index = 0;
        int[] result = new int[isFirstSmaller ? first.length : second.length];

        for (int element : (isFirstSmaller ? second : first)) {
            if (map.containsKey(element)) {
                int count = map.get(element);
                if (count == 1) {
                    map.remove(element);
                } else {
                    map.put(element, count - 1);
                }
                result[index] = element;
                index++;
            }
        }

        return Arrays.copyOf(result, index);
    }

    public static void main(String[] args) {
        ArrayUtils.print(
                intersectUsingMergeSort(
                        new int[] {4,9,5},
                        new int[] {9,4,9,8,4}
                )
        );
        ArrayUtils.print(
                intersectUsingHashMap(
                        new int[] {4,9,5},
                        new int[] {9,4,9,8,4}
                )
        );
    }
}
