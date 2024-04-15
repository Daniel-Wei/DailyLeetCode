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
    public string SmallestFromLeaf(TreeNode root) {
        string res = Helper(root, "", null);
        char[] arr = res.ToCharArray();
        Array.Reverse(arr);
        return new string(arr);
    }
    
    private string Helper(TreeNode curr, string str, string smallest){
        char c = (char)('a' + curr.val);
        
        if(curr.left == null && curr.right == null){
            if(smallest == null){
                return str + c;
            }else{
                string currStr = str + c;
                
                char[] currArr = currStr.ToCharArray();
                Array.Reverse(currArr);
                string reversedCurrStr = new string(currArr);
                
                char[] smallestArr = smallest.ToCharArray();
                Array.Reverse(smallestArr);
                string reversedSmallest = new string(smallestArr);
                
                if(String.Compare(reversedSmallest, reversedCurrStr) == 1){
                    return currStr;
                }else{
                    return smallest;
                }
            }
        }
        
        str += c;
        
        if(curr.left != null){
            smallest = Helper(curr.left, str, smallest);
        }
        
        
        
        if(curr.right != null){
            smallest = Helper(curr.right, str, smallest);
        }
        
        
        return smallest;
    }
}