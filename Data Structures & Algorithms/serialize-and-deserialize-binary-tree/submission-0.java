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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("N#");
            return;
        }

        sb.append(root.val);
        sb.append("#");

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    int idx;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] nodes = data.split("#");
        TreeNode root = buildTree(nodes);
        return root;
    }

    private TreeNode buildTree(String[] nodes) {
        if(idx == nodes.length) {
            return null;
        }

        if(nodes[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[idx]));
        idx++;

        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }
}
