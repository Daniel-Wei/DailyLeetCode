class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairs(nums, lower) - countPairs(nums, upper + 1);
    }

    private long countPairs(int[] nums, int minReq){
        int l = 0;
        int r = nums.length - 1;
        long res = 0l;

        while(l < r){
            if(nums[l] + nums[r] >= minReq){
                // pairs [l, r], [l + 1, r], ... [r - 1, r] are all valid
                res += r - l;
                r--; 
            }else{
                l++;
            }
        }

        return res;
    }
}