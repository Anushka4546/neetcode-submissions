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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = -1000000000;

        maxPathSum01(root);
        return maxSum;
    }

    private int maxPathSum01(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxPathSum01(root.left);
        int right = maxPathSum01(root.right);

        int maxPath = Math.max(root.val, Math.max(left, right) + root.val);
        maxSum = Math.max(maxSum, Math.max(maxPath, left + right + root.val));

        return maxPath;
    }
}
