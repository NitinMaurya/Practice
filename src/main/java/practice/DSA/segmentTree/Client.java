package practice.DSA.segmentTree;

import practice.DSA.leetcode.ArrayUtils;

public class Client {
    public static void main(String[] args) {

        int[] array = new int[]{1,2,3,4,5,6,7};
        ArrayUtils.print("Original Array:", array);

//        testSegmentTree(new SumSegmentTree(array), array);
        testSegmentTree(new MaximumSegmentTree(array), array);
    }

    private static void testSegmentTree(SegmentTree segmentTree, int[] array) {
        System.out.println("Segment Tree: ");
        segmentTree.print();
        System.out.println("=================================");

        int query = segmentTree.query(array, 0, 2);
        System.out.printf("QUERY[%d,%d] = %d%n", 0, 2, query);

        System.out.println("=================================");

        segmentTree.update(array, 4, 8);
        ArrayUtils.print("Updated Array:", array);
        System.out.println("Updated Segment Tree:");
        segmentTree.print();

        System.out.println("=================================");

        query = segmentTree.query(array, 0, 5);
        System.out.printf("QUERY[%d,%d] = %d%n", 0, 5, query);
    }
}
