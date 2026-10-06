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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) {
            return root == null && subRoot == null;
        }

        boolean inLeft = isSubtree(root.left, subRoot);
        boolean inRight = isSubtree(root.right, subRoot);

        if(root.val == subRoot.val) {
            return inLeft || inRight || isSameTree(root, subRoot);
        }

        return inLeft || inRight;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null) {
            if(p == null && q == null) {
                return true;
            } else {
                return false;
            }
        }

        boolean isLeftSame = isSameTree(p.left, q.left);
        boolean isRightSame = isSameTree(p.right, q.right);

        return isLeftSame && isRightSame && p.val == q.val;
    }
}
