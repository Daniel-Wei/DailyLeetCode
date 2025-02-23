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
    int pre, post;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // System.out.println(pre);
        // System.out.println(post);
        // System.out.println();

        TreeNode root = new TreeNode(preorder[pre]);
        pre++;

        if(root.val != postorder[post]){
            root.left = constructFromPrePost(preorder, postorder);
        }

        if(root.val != postorder[post]){
            root.right = constructFromPrePost(preorder, postorder);
        }

        post++;

        return root;

       
    }
}