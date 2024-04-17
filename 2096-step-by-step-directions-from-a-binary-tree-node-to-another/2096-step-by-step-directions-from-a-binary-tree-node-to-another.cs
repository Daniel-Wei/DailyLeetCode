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
    public string GetDirections(TreeNode root, int startValue, int destValue) {
        // string pathToStart = Helper(root, "", startValue);
        // string pathToDest = Helper(root, "", destValue);
        
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        Find(root, startValue, start);
        Find(root, destValue, dest);
        string pathToStart = new string(start.ToString().Reverse().ToArray());
        string pathToDest = new string(dest.ToString().Reverse().ToArray());
        
        // Remove common path
        int i = 0;
        while(i < pathToStart.Length && i < pathToDest.Length){
            if(pathToStart[i] == pathToDest[i]){
                i++;
            }else{
                break;
            }
        }
        
        return new string('U', pathToStart.Length - i) + pathToDest.Substring(i);
    }
    
    private bool Find(TreeNode curr, int val, StringBuilder sb) {
        if (curr.val == val) return true;
        if (curr.left != null && Find(curr.left, val, sb)) { 
            sb.Append("L");
            return true;
        }
        if (curr.right != null && Find(curr.right, val, sb))  {
            sb.Append("R");
            return true;
        }
        return false;
    }
    
    private string Helper(TreeNode curr, string currPath, int val){
        if(curr.val == val){
            return currPath;
        }
        
        if(curr.left != null){
            string res = Helper(curr.left, currPath + "L", val);
            if(res != null){
                return res;
            }
        }
        if(curr.right != null){
            string res = Helper(curr.right, currPath + "R", val);
            if(res != null){
                return res;
            }
        }
        return null;
    }
}