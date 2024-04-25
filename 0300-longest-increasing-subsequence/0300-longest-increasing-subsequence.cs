public class Solution {
    public int LengthOfLIS(int[] nums) {
        int[]dp = new int[nums.Length];
        
        for(int i = 0; i < nums.Length; i++){
            
            for(int j = i; j >=0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.Max(dp[i], dp[j]);
                }
            }
            
            dp[i] += 1;
        }
        
        return dp.Max();
    }
}