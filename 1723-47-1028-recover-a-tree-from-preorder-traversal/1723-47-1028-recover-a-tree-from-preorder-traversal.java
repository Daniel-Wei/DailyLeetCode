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
    public TreeNode recoverFromPreorder(String traversal) {
        char[] chars = traversal.toCharArray();

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while(i < chars.length && chars[i] != '-'){
            sb.append(chars[i]);
            i++;
        }

        int rootVal = Integer.parseInt(sb.toString());
        TreeNode root = new TreeNode(rootVal);

        HashMap<TreeNode, Integer> m = new HashMap<TreeNode, Integer>();
        m.put(root, 0);

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        dfs(chars, i - 1, m, stack);

        return root;
    }

    private void dfs(char[] chars, int index, HashMap<TreeNode, Integer> m, Stack<TreeNode> stack){
        TreeNode prev = stack.peek();
        int depth = m.get(prev);

        int currDepth = 0;

        for(int i = index + 1; i < chars.length; i++){
            if(chars[i] == '-'){
                currDepth++;
            }else{
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = index + currDepth + 1;

        while(i < chars.length && chars[i] != '-'){
            sb.append(chars[i]);
            i++;
        }

        if(sb.length() > 0){
            int nextVal = Integer.parseInt(sb.toString());
            TreeNode next = new TreeNode(nextVal);
            m.put(next, currDepth);

            if(currDepth > depth){
                prev.left = next;
            }else{
                while(m.get(stack.peek()) >= currDepth){
                    stack.pop();
                }
                prev = stack.pop();
                prev.right = next;
            }

            stack.push(next);
            dfs(chars, i - 1, m, stack);
        }
        return ;
    }
}