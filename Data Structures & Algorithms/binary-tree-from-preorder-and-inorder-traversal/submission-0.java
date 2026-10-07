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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if(pStart > pEnd) {
            return null;
        }

        if(pStart == pEnd) {
            return new TreeNode(preorder[pStart]);
        }

        TreeNode root = new TreeNode(preorder[pStart]);
        int rootIdx = iStart;

        while(rootIdx < iEnd) {
            if(inorder[rootIdx] == root.val) {
                break;
            }
            rootIdx++;
        }

        int numElementsOnLeft = rootIdx - iStart;

        root.left = buildTree(preorder, inorder, pStart + 1, pStart + numElementsOnLeft, iStart, rootIdx - 1);
        root.right = buildTree(preorder, inorder, pStart + numElementsOnLeft + 1, pEnd, rootIdx + 1, iEnd);

        return root;
    }
}
