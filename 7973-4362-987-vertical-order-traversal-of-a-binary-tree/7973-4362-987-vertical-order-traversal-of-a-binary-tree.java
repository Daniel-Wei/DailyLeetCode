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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, PriorityQueue<TreeNode>> res = new HashMap<>();
        

        HashMap<TreeNode, int[]> posMap = new HashMap<>();
        posMap.put(root, new int[] {0, 0});

        PriorityQueue<TreeNode> firstCol = new PriorityQueue<TreeNode>((n1, n2) -> {
            int r1 = posMap.get(n1)[0];
            int r2 = posMap.get(n2)[0];

            if(r1 == r2){
                return n1.val - n2.val;
            }
            return r1 - r2;
        });
        
        firstCol.offer(root);
        res.put(0, firstCol);

        
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode prev = q.poll();
            int[] pos = posMap.get(prev);
            int row = pos[0];
            int col = pos[1];

            if(prev.left != null){
                posMap.put(prev.left, new int[] {row + 1, col - 1});

                PriorityQueue<TreeNode> leftCol = res.getOrDefault(col - 1, 
                    new PriorityQueue<TreeNode>((n1, n2) -> {
                        int r1 = posMap.get(n1)[0];
                        int r2 = posMap.get(n2)[0];

                        if(r1 == r2){
                            return n1.val - n2.val;
                        }
                        return r1 - r2;
                    }));
                leftCol.offer(prev.left);
                res.put(col - 1, leftCol);
                
                q.offer(prev.left);
            }


            if(prev.right != null){
                posMap.put(prev.right, new int[] {row + 1, col + 1});

                PriorityQueue<TreeNode> rightCol = res.getOrDefault(col + 1, 
                    new PriorityQueue<TreeNode>((n1, n2) -> {
                        int r1 = posMap.get(n1)[0];
                        int r2 = posMap.get(n2)[0];

                        if(r1 == r2){
                            return n1.val - n2.val;
                        }
                        return r1 - r2;
                    }));
                rightCol.offer(prev.right);
                res.put(col + 1, rightCol);
                
                q.offer(prev.right);
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> keys = new ArrayList<Integer> (res.keySet());
        Collections.sort(keys);

        for(int k : keys){
            PriorityQueue<TreeNode> pq = res.get(k);
            List<Integer> curr = new ArrayList<Integer>();

            while(!pq.isEmpty()){
                curr.add(pq.poll().val);
            }

            result.add(curr);
        }

        return result;

    }
}