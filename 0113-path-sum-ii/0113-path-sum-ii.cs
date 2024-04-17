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
    public IList<IList<int>> PathSum(TreeNode root, int targetSum) {
        IList<IList<int>> paths = new List<IList<int>>();
        
        if(root == null){
            return paths;
        }
        Helper(root, targetSum, paths, 0, new List<int>());
        return paths;
    }
    
    private void Helper(TreeNode curr, int targetSum, IList<IList<int>> paths, int currSum, List<int>path){
        
        path.Add(curr.val);
        
        if(curr.left == null && curr.right == null && currSum + curr.val == targetSum){
            paths.Add(path);
        }
        
        
        // Key point: copy curr path by new List<int>(path)
        if(curr.left != null){
            Helper(curr.left, targetSum, paths, currSum + curr.val, new List<int>(path));
        }

        if(curr.right != null){
            Helper(curr.right, targetSum, paths, currSum + curr.val, new List<int>(path));
        }   
    }
}