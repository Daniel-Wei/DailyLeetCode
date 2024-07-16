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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder sPath = new StringBuilder();
        getPathFromRoot(root, startValue, sPath);
        StringBuilder dPath = new StringBuilder();
        getPathFromRoot(root, destValue, dPath);
    
        int i = 0;
        
        sPath.reverse();
        dPath.reverse();

        //remove initial common paths
        while(i < sPath.length() && i < dPath.length()){
            if(sPath.charAt(i) == dPath.charAt(i)){
                i++;
            }else{
                break;
            }
        }
        
        return "U".repeat(sPath.length() - i) + dPath.substring(i);
    }
    
    private boolean getPathFromRoot(TreeNode curr, int nodeVal, StringBuilder sb){
        if(curr.val != nodeVal){
            if(curr.left != null && getPathFromRoot(curr.left, nodeVal, sb)){
                sb.append('L');
                return true;
            } 
            
            if(curr.right != null && getPathFromRoot(curr.right, nodeVal, sb)){
                sb.append('R');
                return true;
            }
            
            return false;
        }else{
            return true;
        }
    }
    
}