package practice.DSA.fenwickTree;

import practice.DSA.leetcode.ArrayUtils;

import java.util.Arrays;

public class RangeSumFenwickTreeImpl implements FenwickTree {
    private final int[] tree;

    public RangeSumFenwickTreeImpl(int[] array) {
        tree = new int[array.length + 1];
        Arrays.fill(tree, 0);
        for (int i = 0; i < array.length; i++) {
            update(array.length, i, array[i]);
        }
    }

    @Override
    public long query(int index) {
        long sum = 0;
        while (index > 0) {
            sum += tree[index];
            index = index - (index & (-index));
        }
        return sum;
    }

    @Override
    public long query(int startIndex, int endIndex) {
        return query(endIndex) - query(startIndex - 1);
    }

    @Override
    public void update(int arraySize, int index, int value) {
        index++;
        while (index < arraySize + 1) {
            tree[index] += value;

            index = index + (index & (-index)); //  index & (-index) unsets the rightmost set bit
            //  finds the index of next child node
            //  this step updates all the child nodes for the index with the value
        }
    }

    @Override
    public void print() {
        System.out.println("********************");
        ArrayUtils.print(tree);
    }
}
