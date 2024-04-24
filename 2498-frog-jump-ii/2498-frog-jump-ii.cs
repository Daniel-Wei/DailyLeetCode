public class Solution {
    public int MaxJump(int[] stones) {
        if(stones.Length == 2){
            return stones[1];
        }
        int res = 0;
        
        for(int i = 1; i < stones.Length - 1; i++){
            res = Math.Max(res, stones[i+1] - stones[i-1]);
        }
        
//         int res = stones[stones.Length - 1];
        
//         for(int lastSkipped = 1; lastSkipped < stones.Length - 2; lastSkipped++){
//             int curr = Math.Max(stones[lastSkipped + 1], diffs[lastSkipped + 1]);
//             curr = Math.Max(curr, stones[stones.Length - 1] - stones[lastSkipped]);
            
//             res = Math.Min(res, curr);
//         }
        
        return res;
    }
}