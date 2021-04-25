package practice.DSA.segmentTree;

import practice.DSA.leetcode.ArrayUtils;

public class Client {
    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5,6,7};
        ArrayUtils.print("Original Array:", array);

        SegmentTree segmentTree = new SumSegmentTree(array);

        System.out.println("Segment Tree: ");
        segmentTree.print();
        System.out.println("=================================");

        int sum = segmentTree.query(array, 0, 2);
        System.out.printf("SUM[%d,%d] = %d%n", 0, 2, sum);

        System.out.println("=================================");

        segmentTree.update(array, 4, 8);
        System.out.println("Updated Segment Tree:");
        segmentTree.print();

        System.out.println("=================================");

        sum = segmentTree.query(array, 0, 5);
        System.out.printf("SUM[%d,%d] = %d%n", 0, 5, sum);
    }
}
