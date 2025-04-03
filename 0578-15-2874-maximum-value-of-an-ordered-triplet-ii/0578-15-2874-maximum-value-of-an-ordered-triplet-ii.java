class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long[] leftMax = new long[n];
        leftMax[0] = nums[0];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        long[] rightMax = new long[n];
        rightMax[n - 1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(nums[i], rightMax[i + 1]);
        }

        long res = 0;

        for(int i = 1; i < n - 1; i++){
            res = Math.max(res, (leftMax[i] - nums[i]) * rightMax[i + 1]);
        }

        return res;
    }
}