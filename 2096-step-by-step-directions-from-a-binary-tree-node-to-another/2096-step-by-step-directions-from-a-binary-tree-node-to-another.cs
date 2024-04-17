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
        // Dictionary<int, string> dict = new Dictionary<int, string>();
        // ToDict(root, "", dict);
        
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        Find(root, startValue, start);
        Find(root, destValue, dest);
        string pathToStart = new string(start.ToString().Reverse().ToArray());
        string pathToDest = new string(dest.ToString().Reverse().ToArray());
        
        
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
    
    private bool Find(TreeNode root, int val, StringBuilder sb) {
        if (root.val == val) return true;
        if (root.left != null && Find(root.left, val, sb)) { 
            sb.Append("L");
            return true;
        }
        if (root.right != null && Find(root.right, val, sb))  {
            sb.Append("R");
            return true;
        }
        return false;
    }
    
//     private string Helper(TreeNode curr, string currPath, int val, Dictionary<int, string> dict){
//         if(!dict.ContainsKey(curr.val)){
//             dict.Add(curr.val, currPath);
//         }
        
//         if(curr.val != val){
//             if(curr.left != null){
//                 string res = Helper(curr.left, currPath + "L", val, dict);
//                 if(res != null){
//                     return res;
//                 }
//             }
//             if(curr.right != null){
//                 string res = Helper(curr.right, currPath + "R", val, dict);
//                 if(res != null){
//                     return res;
//                 }
//             }
//         }else{
//             return currPath;
//         }
        
//         return null;
//     }
    
//     private void ToDict(TreeNode curr, string currPath, Dictionary<int, string> dict){
//         if(!dict.ContainsKey(curr.val)){
//             dict.Add(curr.val, currPath);
//         }
        
//         if(curr.left != null){
//             ToDict(curr.left, currPath + "L", dict);
//         }
        
//         if(curr.right != null){
//             ToDict(curr.right, currPath + "R", dict);
//         }
//     }
}