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
   public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
       HashSet<Integer> toDelete = new HashSet<Integer>();
       List<TreeNode> forest = new ArrayList<TreeNode>();
       
       for(int v : to_delete){
           toDelete.add(v);
       }
       
       deleteNodes(root, toDelete, forest);
       
       
       // as forest only includes the trees under deleted nodes
       // we need to keep the remaining overall structure as well
       if(!toDelete.contains(root.val)){
           forest.add(root);
       }
       
       return forest;
   }
    
    private TreeNode deleteNodes(TreeNode node, HashSet<Integer> toDelete, List<TreeNode> forest){
        if(node == null){
            return null;
        }

        // make sure depth-most nodes be deleted first
        // meanwhile, update the ancestors
        node.left = deleteNodes(node.left, toDelete, forest);
        node.right = deleteNodes(node.right, toDelete, forest);
        
        if(toDelete.contains(node.val)){
            if(node.left != null){
                forest.add(node.left);
            }
            
            if(node.right != null){
                forest.add(node.right);
            }
            
            return null;
        }
        
        return node;
    }
}