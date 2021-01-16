package practice.DSA.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteDuplicates {
    public static int deleteDuplicates(List<Integer> A) {
        int writeIndex = 1;
        for (int i = 1; i < A.size(); ++i) {
            if (!A.get(writeIndex - 1).equals(A.get(i))) {
                A.set(writeIndex, A.get(i));
                writeIndex++;
            }
        }
        return writeIndex-1;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,6,3));
        int endIndex = deleteDuplicates(input);
        System.out.println(input.subList(0, endIndex));
    }
}
