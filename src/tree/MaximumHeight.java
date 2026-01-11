package tree;

// 1. We need this class definition for the code to work
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int val) { this.val = val; }
//}

public class MaximumHeight {

    // 2. The logic is defined HERE, inside MaximumHeight
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // CORRECTION: Create an instance of THIS class
        MaximumHeight calculator = new MaximumHeight();

        // Call the method on the 'calculator' object
        int result = calculator.maxDepth(root);

        System.out.println("Maximum Height of the tree is: " + result);
    }
}