package practice.DSA.fenwickTree;

import practice.DSA.leetcode.ArrayUtils;

import java.util.Arrays;

public class RangeProductFenwickTreeImpl implements FenwickTree {
    private final int[] tree;

    public RangeProductFenwickTreeImpl(int[] array) {
        this.tree = new int[array.length + 1];
        Arrays.fill(tree, 1);
        buildTree(array);
    }

    private void buildTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            update(array.length + 1, i + 1, array[i]);
        }
    }

    @Override
    public long query(int index) {
        long product = 1;
        while (index > 0) {
            product = product * tree[index]; // cumulating here
            index = index - (index & (-index)); // child index
        }
        return product;
    }

    @Override
    public long query(int startIndex, int endIndex) {
        return query(endIndex) / query(startIndex - 1);
    }

    @Override
    public void update(int arraySize, int index, int value) {
        while (index < arraySize) {
            tree[index] *= value; // cumulating here
            index = index + (index & (-index)); // child index
        }
    }

    @Override
    public void print() {
        ArrayUtils.print(tree);
    }
}
