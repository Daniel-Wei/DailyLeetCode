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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> m = new HashMap<Integer, TreeNode>();
        TreeNode root = new TreeNode();
        Set<Integer> children = new HashSet<Integer>();
        
        for(int[] d : descriptions){
            
            int parentVal = d[0];
            int childVal = d[1];
            children.add(childVal);
            TreeNode parent = m.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode child = m.getOrDefault(childVal, new TreeNode(childVal));
            
            if(d[2] == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }
            
            m.put(parentVal, parent);
            m.put(childVal, child);
        }
        
        
        for(Integer key : m.keySet()){
            if(!children.contains(key)){
                root = m.get(key);
                break;
            }
        }
        
        return root;
    }
}