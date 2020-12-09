package practice.DSA.practice;

// incomplete: asked in gaana interview.

public class MaxPathSum {
    static int count = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean isFirst;
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.isFirst) {
            int maxPath = Math.max(maxPathSum(root.left), maxPathSum(root.right));
            if (maxPath > count) {
                count = maxPath;
            }
            return Integer.MIN_VALUE;
        } else {
            int lHeight = maxPathSum(root.left);
            int rHeight = maxPathSum(root.right);
            return Math.max(lHeight + rHeight, Math.max(lHeight, rHeight)) + 1;
        }
    }

    public static void main(String[] args) {

    }

}
