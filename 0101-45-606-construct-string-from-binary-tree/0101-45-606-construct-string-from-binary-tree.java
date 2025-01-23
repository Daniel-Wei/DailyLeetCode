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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(root.val);
        DFS(root.left, sb);
        if(root.left == null && root.right != null){
            sb.append("()");
        }
        DFS(root.right, sb);

        return sb.toString();
    }

    public void DFS(TreeNode node, StringBuilder sb){
        if(node != null){
            sb.append("(");
            sb.append(node.val);
            
            DFS(node.left, sb);
            
            if(node.left == null && node.right != null){
                sb.append("()");
            }
            
            DFS(node.right, sb);
            sb.append(")");
        }
    }
}