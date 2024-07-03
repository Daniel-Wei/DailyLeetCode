class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n <= 4){
            return 0;
        }
        Arrays.sort(nums);
        
        int l = 0;
        int r = n - 4;
        int count = 0;
        int res = nums[r] - nums[l];

        while(count < 3){
            l++;
            r++;
            
            res = Math.min(res, nums[r] - nums[l]);
            count++;
        }
       
        
        return res;
    }
}