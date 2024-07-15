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
            TreeNode parent = new TreeNode(d[0]);
            
            if(m.containsKey(d[0])){
                parent = m.get(d[0]);
            }
            
            
            TreeNode child = new TreeNode(d[1]);
            
            if(m.containsKey(d[1])){
                child = m.get(d[1]);
            }
            
            children.add(d[1]);
            
            if(d[2] == 1){
                parent.left = child;
            }else{
                parent.right = child;
            }
            
            m.put(d[0], parent);
            m.put(d[1], child);
        }
        
        
        for(Integer key : m.keySet()){
            if(!children.contains(key)){
                root = m.get(key);
            }
        }
        
        return root;
    }
}