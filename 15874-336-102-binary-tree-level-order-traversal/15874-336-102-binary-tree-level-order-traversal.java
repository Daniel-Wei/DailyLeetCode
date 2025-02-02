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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int levelNodes = 1;
        int currLevelNodes = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            Queue<TreeNode> currLevelQueue = new LinkedList<TreeNode>();
            List<Integer> currLevelVals = new ArrayList<Integer>();

            while(!q.isEmpty()){
                TreeNode node = q.poll();
                if(node != null){
                    currLevelVals.add(node.val);
                    currLevelQueue.add(node);
                }
            }

            if(currLevelVals.size() > 0){
                res.add(currLevelVals);
            }

            while(!currLevelQueue.isEmpty()){
                TreeNode node = currLevelQueue.poll();
                q.offer(node.left);
                q.offer(node.right);
            }
            
        }

        return res;
    }
}