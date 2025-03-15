class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int curr = nums[0];

        for(int i = 1; i < nums.length; i++){
            curr = Math.max(curr + nums[i], nums[i]);
            res = Math.max(res, curr);
        }

        return res;
    }
}