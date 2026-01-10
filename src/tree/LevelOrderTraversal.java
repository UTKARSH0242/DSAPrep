package tree;

import java.util.ArrayList;
import java.util.List;

// 1. Definition for the binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 2. The O(N^2) Solution
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Calculate total height of tree
        int h = height(root);

        // Iterate through every level one by one
        for (int i = 1; i <= h; i++) {
            List<Integer> currentLevelList = new ArrayList<>();
            getLevel(root, i, currentLevelList);
            result.add(currentLevelList);
        }

        return result;
    }

    // Helper: Calculate height
    private int height(TreeNode root) {
        if (root == null) return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);
        return Math.max(lheight, rheight) + 1;
    }

    // Helper: Traverse to a specific level
    private void getLevel(TreeNode root, int level, List<Integer> currentLevelList) {
        if (root == null) return;

        if (level == 1) {
            currentLevelList.add(root.val);
        } else if (level > 1) {
            getLevel(root.left, level - 1, currentLevelList);
            getLevel(root.right, level - 1, currentLevelList);
        }
    }
}

// 3. Main Execution Class
public class LevelOrderTraversal {
    public static void main(String[] args) {
        // Constructing the following tree:
        //      3
        //     / \
        //    9  20
        //      /  \
        //     15   7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution solution = new Solution();
        List<List<Integer>> result = solution.levelOrder(root);

        // Print the result
        System.out.println("Level Order Traversal (O(N^2) approach):");
        System.out.println(result);
    }
}