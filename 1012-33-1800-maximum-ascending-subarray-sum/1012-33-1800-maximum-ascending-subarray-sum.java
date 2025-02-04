class Solution {
    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int currSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i - 1]){
                res = Math.max(res, currSum);
                currSum = nums[i];
            }else{
                currSum += nums[i];
            }
        }

        return Math.max(res, currSum);
    }
}