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
    private ArrayList<Integer> sortedList = new ArrayList<Integer>();
    public TreeNode balanceBST(TreeNode root) {
        inOrderTraversal(root);
        return constructBalancedBST(0, sortedList.size() - 1);
    }
    
    private void inOrderTraversal(TreeNode root){
        if(root != null){
            inOrderTraversal(root.left);
            sortedList.add(root.val);
            inOrderTraversal(root.right);
        }
    }
    private TreeNode constructBalancedBST(int s, int e){
        int mid = (s + e) / 2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        
        if(s == e){
            return root;
        }
        
        if(mid == s){
            root.right = new TreeNode(sortedList.get(e));
        }else if(mid == e){
            root.left = new TreeNode(sortedList.get(s));
        }else{
            root.left = constructBalancedBST(s, mid - 1);
            root.right = constructBalancedBST(mid + 1, e);
        }
        
        return root;
    }
}