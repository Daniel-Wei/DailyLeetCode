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
class Solution{
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> memo = new HashMap<TreeNode, Integer>();
        return dfs(root, memo);

    }

    private int dfs(TreeNode node, HashMap<TreeNode, Integer> memo){
        if(node == null){
            return 0;
        }

        if(memo.containsKey(node)){
            return memo.get(node);
        }

        int val = node.val;

        if(node.left != null){
            val += dfs(node.left.left, memo) + dfs(node.left.right, memo);
        }

        if(node.right != null){
            val += dfs(node.right.left, memo) + dfs(node.right.right, memo);
        }

        val = Math.max(val, dfs(node.left, memo) + dfs(node.right, memo));
        memo.put(node, val);

        return val;
    }

    
}