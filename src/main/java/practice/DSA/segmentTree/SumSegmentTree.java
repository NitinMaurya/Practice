package practice.DSA.segmentTree;

import practice.DSA.leetcode.ArrayUtils;

public class SumSegmentTree implements SegmentTree {
    private final int[] tree;

    public SumSegmentTree(int[] array) {
        this.tree = new int[2 * array.length];
        buildTree(array, 1, 0, array.length - 1);
    }

    /*
     *   Complexity: O(N)
     * */
    private void buildTree(int[] array, int node, int start, int end) {
        if (start == end) {
            tree[node] = array[start];
        } else {
            int mid = start + (end - start) / 2;
            buildTree(array, 2 * node, start, mid); // recurse on Left
            buildTree(array, 2 * node + 1, mid + 1, end); // recurse on right
            tree[node] = tree[2 * node] + tree[2 * node + 1]; // set internal node
            // (operation can be anything as per question)
        }
        // ArrayUtils.print(tree);
        // System.out.printf("Assigned tree[%d] = %d%n", node, tree[node]);
    }


    /*
     *   Complexity: O(logN)
     * */
    @Override
    public void update(int[] array, int index, int newValue) {
        array[index] = newValue;
        updateUtil(1, 0, array.length - 1, index, newValue);
    }

    private void updateUtil(int node, int start, int end, int index, int newValue) {
        if (start == end) {
            tree[node] = newValue;
        } else {
            int mid = start + (end - start) / 2;
            if (index <= mid) {
                updateUtil(2 * node, start, mid, index, newValue);
            } else {
                updateUtil(2 * node + 1, mid + 1, end, index, newValue);
            }
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
    }


    /*
     *   Complexity: O(logN)
     * */
    @Override
    public int query(int[] array, int left, int right) {
        return queryUtil(1, 0, array.length - 1, left, right);
    }

    private int queryUtil(int node, int start, int end, int left, int right) {
        if (left <= start && right >= end) {
            return tree[node];
        }
        if (left > right || right < start || left > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int leftSum = queryUtil(2 * node, start, mid, left, right);
        int rightSum = queryUtil(2 * node + 1, mid + 1, end, left, right);
        return leftSum + rightSum;
    }

    @Override
    public void print() {
        ArrayUtils.print(tree);
    }
}
