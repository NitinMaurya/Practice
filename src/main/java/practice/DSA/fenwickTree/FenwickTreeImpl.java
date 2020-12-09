package practice.DSA.fenwickTree;

import java.util.Arrays;

public class FenwickTreeImpl implements FenwickTree {
    private int[] tree;

    public FenwickTreeImpl(int[] array){
        tree = new int[array.length + 1];
        Arrays.fill(tree, 0);
        for(int i = 0; i < array.length; i++){
            updateTree(array.length, i, array[i]);
        }
    }

    @Override
    public int getSum(int index) {
        int sum  = 0;
        while(index > 0){
            sum += tree[index];
            index = index - (index & (-index));
        }
        return sum;
    }

    @Override
    public int getSum(int startIndex, int endIndex) {
        return getSum(endIndex) - getSum(startIndex - 1);
    }

    @Override
    public void updateTree(int arraySize, int index, int value) {
        index++;
        while(index < arraySize + 1){
            tree[index] += value;

            index = index + (index & (-index)); //  index & (-index) unsets the rightmost set bit
                                                //  finds the index of next child node
                                                //  this step updates all the child nodes for the index with the value
        }
    }

    @Override
    public void print(){
        System.out.println();
        for (int value : tree) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

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
