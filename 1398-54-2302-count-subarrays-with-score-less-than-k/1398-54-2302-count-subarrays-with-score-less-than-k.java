class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long res = 0;
        int l = 0;
        int r = 0;
        long currSum = nums[0];

        while(r < n){
            if(currSum * (r - l + 1) < k){
                res += r - l + 1;
                r++;
                if(r < n){
                    currSum += nums[r];
                }
            }else{
                currSum -= nums[l];
                l++;
            }

        }

        return res;
    }
}