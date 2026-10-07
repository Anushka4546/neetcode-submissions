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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        int level = 0;
        que.add(root);

        while(que.size() > 0) {
            int siz = que.size();
            ans.add(new ArrayList<>());
            while(siz-- > 0) {
                TreeNode node = que.removeFirst();
                ans.get(level).add(node.val);

                if(node.left != null) {
                    que.add(node.left);
                }

                if(node.right != null) {
                    que.add(node.right);
                }
            }
            level++;
        }

        return ans;
    }
}
