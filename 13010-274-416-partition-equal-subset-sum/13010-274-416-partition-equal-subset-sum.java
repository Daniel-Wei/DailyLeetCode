class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % 2 != 0){
            return false;
        }

        int targetSum = sum / 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for(int num : nums){
            for(int currSum = targetSum; currSum >= num; currSum--){
                dp[currSum] = dp[currSum - num] || dp[currSum];
            }

            if(dp[targetSum]){
                return true;
            }
        }

        return false;
       
    }
}