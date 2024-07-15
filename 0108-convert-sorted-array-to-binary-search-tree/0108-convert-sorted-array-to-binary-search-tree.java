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
    public TreeNode sortedArrayToBST(int[] nums) {
        return toBST(0, nums.length, nums);
    }
    
    private TreeNode toBST(int start, int end, int[]nums){
        if(start == end){
            return null;
        }
        
        int slow = start;
        int fast = start;
        
        while(fast + 1 < end){
            slow += 1;
            fast += 2;
        }
        
        TreeNode root = new TreeNode(nums[slow]);
        root.left = toBST(start, slow, nums);
        root.right = toBST(slow + 1, end, nums);
        
        return root;
        
    }
}