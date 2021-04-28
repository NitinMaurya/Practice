package practice.DSA.fenwickTree;

public class Client {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        FenwickTree rangeSumFenwickTree = new RangeSumFenwickTreeImpl(input);
        FenwickTree rangeProductFenwickTree = new RangeProductFenwickTreeImpl(input);
        testFenwickTree(rangeProductFenwickTree, input);
    }

    private static void testFenwickTree(FenwickTree fenwickTree, int[] input) {
        fenwickTree.print();
        System.out.println(fenwickTree.query(4));

        fenwickTree.update(input.length, 3, 10);
        fenwickTree.print();
        System.out.println(fenwickTree.query(4));
        System.out.println(fenwickTree.query(3,5));
    }
}
