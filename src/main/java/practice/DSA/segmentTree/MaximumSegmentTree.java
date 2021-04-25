package practice.DSA.segmentTree;

import practice.DSA.leetcode.ArrayUtils;

public class MaximumSegmentTree implements SegmentTree {
    private final int[] tree;

    public MaximumSegmentTree(int[] array) {
        this.tree = new int[2 * array.length];
        build(array);
    }

    @Override
    public void build(int[] array) {
        buildUtil(array, 1, 0, array.length-1);
    }

    private void buildUtil(int[] array, int node, int start, int end) {
        if (start == end) {
            tree[node] = array[start];
        } else {
            int mid = mid(start, end);
            buildUtil(array, 2 * node, start, mid);
            buildUtil(array, 2 * node + 1, mid + 1, end);
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }

    private int mid(int start, int end) {
        return start + (end - start) / 2;
    }

    @Override
    public void update(int[] array, int index, int newValue) {
        array[index] = newValue;
        updateUtil(1, 0, array.length-1, index, newValue);
    }

    private void updateUtil(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            tree[node] = newValue;
        } else {
            int mid = mid(start, end);
            if (index <= mid) {
                updateUtil(2 * node, start, mid, index, newValue);
            } else {
                updateUtil(2 * node + 1, mid + 1, end, index, newValue);
            }
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }
    }

    @Override
    public int query(int[] array, int left, int right) {
        return queryUtil(1, 0, array.length - 1, left, right);
    }

    private int queryUtil(int node, int start, int end, int left, int right) {
        if (left <= start && right >= end) {
            return tree[node];
        }
        if (left > right || right < start || left > end) {
            return Integer.MIN_VALUE;
        }
        int mid = mid(start, end);
        int leftMax = queryUtil(2 * node, start, mid, left, right);
        int rightMax = queryUtil(2 * node + 1, mid + 1, end, left, right);
        return Math.max(leftMax, rightMax);
    }

    @Override
    public void print() {
        ArrayUtils.print(tree);
    }
}
