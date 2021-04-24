package practice.DSA.fenwickTree;

public class Client {
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        FenwickTree fenwickTree = new FenwickTreeImpl(input);

        fenwickTree.print();
        System.out.println(fenwickTree.getSum(4));

        fenwickTree.updateTree(input.length, 3, 10);
        fenwickTree.print();
        System.out.println(fenwickTree.getSum(4));
    }
}
