public class Solution {
    public int FindTargetSumWays(int[] nums, int target) {
        List<int> possibleSums = new List<int>(){nums[0], -nums[0]};
        for(int i = 1; i < nums.Length; i++){
            List<int> curr = new();
            possibleSums.ForEach(sum => {
                curr.Add(sum + nums[i]);
                curr.Add(sum - nums[i]);
            });
            possibleSums = curr; 
            
           
        }
        
        return possibleSums.Where(s => s == target).Count();
    }
}