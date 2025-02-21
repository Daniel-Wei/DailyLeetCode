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
class FindElements {
    // List<Integer> lst = new ArrayList<Integer>();
    HashSet<Integer> hs = new HashSet<Integer>();

    public FindElements(TreeNode root) {
        root.val = 0;
        // lst.add(0);
        bfs(root);
        hs.add(0);
    }

    private void bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.left != null){
                curr.left.val = curr.val * 2 + 1;
                q.offer(curr.left);
                hs.add(curr.left.val);
            }

            if(curr.right != null){
                curr.right.val = curr.val * 2 + 2;
                q.offer(curr.right);
                hs.add(curr.right.val);
            }
            
            // if(curr.left != null){
            //     curr.left.val = curr.val * 2 + 1;
            //     if(curr.left.val > lst.size()){
            //         int diff = curr.left.val - lst.size();
            //         for(int i = 0; i < diff; i++){
            //             lst.add(-1);
            //         }
            //     }
            //     lst.add(curr.left.val);
            //     q.offer(curr.left);
            // }else{
            //     lst.add(-1);
            // }

            // if(curr.right != null){
            //     curr.right.val = curr.val * 2 + 2;
            //     if(curr.right.val > lst.size()){

            //         int diff = curr.right.val - lst.size();
            //         for(int i = 0; i < diff; i++){
            //             lst.add(-1);
            //         }
            //     }
            //     lst.add(curr.right.val);
            //     q.offer(curr.right);
            // }else{
            //     lst.add(-1);
            // }
        }
    }
    
    public boolean find(int target) {
        // return lst.get(target) != -1;
        return hs.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */