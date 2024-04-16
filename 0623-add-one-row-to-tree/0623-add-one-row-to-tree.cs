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
    public TreeNode AddOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val, root, null);
        }
        
        Helper(root, val, depth);
        
        return root;
    }
    
    private void Helper(TreeNode curr, int val, int depth){
        if(depth == 2){
            TreeNode newLeft = new TreeNode(val, curr.left, null);
            TreeNode newRight = new TreeNode(val, null, curr.right);
            curr.left = newLeft;
            curr.right = newRight;
        }else{
            if(curr.left != null){
                Helper(curr.left, val, depth - 1);
            }
            
            if(curr.right != null){
                Helper(curr.right, val, depth - 1);
            }
        }
    }
}