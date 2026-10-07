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
    int prevVal = -1000000007;
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(!isValidBST(root.left)) {
            return false;
        }

        if(root.val <= prevVal) {
            return false;
        }

        prevVal = root.val;

        if(!isValidBST(root.right)) {
            return false;
        }

        return true;
    }
}
