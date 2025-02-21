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
    TreeNode res = new TreeNode();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, 0, k);
        return res.val;
    }

    private int dfs(TreeNode curr, int count, int k){
        if(curr.left != null){
            count = dfs(curr.left, count, k);
        }

        count++;

        if(count == k){
            res = curr;
        }

        if(curr.right != null){
            count = dfs(curr.right, count, k);
        }

        return count;
    }
}