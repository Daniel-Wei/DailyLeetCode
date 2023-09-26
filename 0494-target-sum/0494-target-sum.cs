public class Solution {
    public int FindTargetSumWays(int[] nums, int target) {
        
        // Basic Solution
//         List<int> possibleSums = new List<int>(){nums[0], -nums[0]};
//         for(int i = 1; i < nums.Length; i++){
//             List<int> curr = new();
//             possibleSums.ForEach(sum => {
//                 curr.Add(sum + nums[i]);
//                 curr.Add(sum - nums[i]);
//             });
//             possibleSums = curr; 
//         }
        
//         return possibleSums.Where(s => s == target).Count();
        
        
        int sum = nums.Sum();
        //edge cases
        if(target > sum || target < -sum){
            return 0;
        }
        
        //1-d memo dp
        //no explicitly saving all possible sums every time
        int[]memo = new int[sum * 2 + 1];
        memo[sum] = 1; //represents 0
        for(int i = 0; i < nums.Length; i++){
            int[]next = new int[sum * 2 + 1];
            for(int k = 0; k < sum * 2 + 1; k++){
                if(memo[k] != 0){
                    next[k + nums[i]] += memo[k];
                    next[k - nums[i]] += memo[k];
                }
            }
            memo = next;
        }
        return memo[sum + target];
    }
}