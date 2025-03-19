class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
    	int i = 0;
        int res = 0;

        while(i < n) {
            if(nums[i] == 0){
                if(i + 3 > n){
                    return - 1;
                }

                res++;
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
            }

            i++;
        }

        return res;

    }
}