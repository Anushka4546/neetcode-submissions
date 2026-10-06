/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean isBalancedTree;
    public boolean isBalanced(TreeNode root) {
        isBalancedTree = true;
        findHeight(root);
        return isBalancedTree;
    }

    public int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = findHeight(root.left);
        int r = findHeight(root.right);

        if(Math.abs(l - r) > 1) {
            isBalancedTree = false;
        }

        return Math.max(l, r) + 1;
    }
}
