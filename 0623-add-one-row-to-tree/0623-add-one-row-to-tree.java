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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        return dfs(root, v, d, 0);
    }
    
    private TreeNode dfs(TreeNode node, int v, int d, int dir) {
        if (d == 1) {
            TreeNode res = new TreeNode(v);
            if (dir == 0) res.left = node;
            else res.right = node;
            return res;
        }
        if (node == null) return node;
        node.right = dfs(node.right, v, d - 1, 1);
        node.left = dfs(node.left, v, d - 1, 0);
        return node;
    }
}