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
    int K;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        K = k;
        ans = -1;
        findKthSmallest(root);
        return ans;
    }

    private void findKthSmallest(TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left != null) {
            findKthSmallest(root.left);
        }

        K--;
        if(K == 0) {
            ans = root.val;
        }

        if(root.right != null) {
            findKthSmallest(root.right);
        }
    }
}
