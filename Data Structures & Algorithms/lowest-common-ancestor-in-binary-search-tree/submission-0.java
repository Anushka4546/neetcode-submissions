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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        TreeNode lca = null;

        findNodeToRootPath(root, p, path1);
        findNodeToRootPath(root, q, path2);

        int i = path1.size() - 1;
        int j = path2.size() - 1; 

        while(i >= 0 && j >= 0) {
            if(path1.get(i).val != path2.get(j).val) {
                break;
            }

            lca = path1.get(i);
            i--;
            j--;
        }

        return lca;
    }

    private void findNodeToRootPath(TreeNode root , TreeNode p, List<TreeNode> path) {
        if(root == null) {
            return;
        }

        if(root.val == p.val) {
            path.add(root);
            return;
        } else if(root.val > p.val) {
            findNodeToRootPath(root.left, p, path);
            if(path.size() > 0) {
                path.add(root);
            }
        } else {
            findNodeToRootPath(root.right, p, path);
            if(path.size() > 0) {
                path.add(root);
            }
        }
    }
}
