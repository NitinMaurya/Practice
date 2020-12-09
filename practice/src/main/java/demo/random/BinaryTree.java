package demo.random;

public class BinaryTree {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
        }
    }

    enum Traversal{
        PRE_ORDER,
        POST_ORDER,
        IN_ORDER
    }

    int maxDiameter = 0;
    TreeNode root;

    public BinaryTree(int[] data){
        this.root = constructTree(data, root, 0);
    }

    public TreeNode constructTree(int[] data, TreeNode root, int i) {
        if(i < data.length){
            root = new TreeNode(data[i]);
            root.left = constructTree(data, root.left, 2 * i + 1);
            root.right = constructTree(data, root.right, 2 * i + 2);
        }
        return root;
    }

    public int getDiameter(){
        height(root);
        return maxDiameter;
    }

    public int height(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int diameter = leftHeight + rightHeight;
        if(diameter > maxDiameter){
            maxDiameter = diameter;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void print(TreeNode root, Traversal traversal){
        switch (traversal){
            case IN_ORDER:
                System.out.print("InOrder: "); inOrder(root); break;
            case PRE_ORDER:
                System.out.print("PreOrder: "); preOrder(root); break;
            case POST_ORDER:
                System.out.print("PostOrder: "); postOrder(root); break;
            default:
                System.out.println("Not a Valid choice");
        }
        System.out.println();
    }

    private void postOrder(TreeNode root) {
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    private void preOrder(TreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(new int[]{1,2,3,4,5,6,7,8});

        System.out.println("Diameter: " + tree.getDiameter());
        System.out.println("Height: " + tree.height(tree.root));
        tree.print(tree.root, Traversal.PRE_ORDER);
        tree.print(tree.root, Traversal.IN_ORDER);
        tree.print(tree.root, Traversal.POST_ORDER);

    }
}
