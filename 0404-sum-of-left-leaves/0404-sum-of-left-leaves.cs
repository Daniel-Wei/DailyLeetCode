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
    public int SumOfLeftLeaves(TreeNode root) {
        return Helper(root, 0, false);
    }
    
    private int Helper(TreeNode node, int total, bool left){
        //base case
        if(node.left == null && node.right == null){
            if(left){
                return total + node.val;
            }else{
                return total;
            }
        }
      
        if(node.left != null){
            total = Helper(node.left, total, true);
        }
        
        if(node.right != null){
            total = Helper(node.right, total, false);
        }
        
        return total;
    }
}