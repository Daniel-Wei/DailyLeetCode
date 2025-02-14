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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> nodes = new ArrayList<Integer>();
        constructArray(root, nodes);
        List<List<Integer>> res = new ArrayList<>();

        for(int q : queries){
            res.add(binarySearch(q, nodes));
        }

        return res;
    }

    private void constructArray(TreeNode curr, List<Integer> nodes){
        if(curr != null){
            constructArray(curr.left, nodes);
            nodes.add(curr.val);
            constructArray(curr.right, nodes);
        }
    }

    private List<Integer> binarySearch(int q, List<Integer> nodes){
        int low = 0;
        int high = nodes.size() - 1;

        if(nodes.get(low) > q){
            return Arrays.asList(-1, nodes.get(low));
        }

        if(nodes.get(high) < q){
            return Arrays.asList(nodes.get(high), -1);
        }

        while(low < high){
            int mid = (low + high) / 2;
            int midVal = nodes.get(mid);

            if(nodes.get(mid) == q){
                return Arrays.asList(midVal, midVal);
            }

            if(nodes.get(mid) > q){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        int val = nodes.get(low);

        if(val == q){
            return Arrays.asList(val, val);
        }else if(val > q){
            return Arrays.asList(nodes.get(low - 1), val);
        }else{
            return Arrays.asList(val, nodes.get(low + 1));
        }
    }
}