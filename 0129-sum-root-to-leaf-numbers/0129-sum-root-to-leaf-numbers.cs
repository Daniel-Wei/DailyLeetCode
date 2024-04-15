/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int SumNumbers(TreeNode root) {
        return Helper(root, 0);
    }
    
    private int Helper(TreeNode curr, int sum){
        if(curr.left == null && curr.right == null){
            return sum * 10 + curr.val;
        }
        
        sum = 10 * sum + curr.val;
        int res = 0;
        
        if(curr.left != null){
            res += Helper(curr.left, sum);
        }
        
        
        if(curr.right != null){
            res += Helper(curr.right, sum);
        }
        
        
        return res;
    }
}