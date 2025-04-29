class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;

        for(int num : nums){
            max = Math.max(max, num);
        }

        int maxCount = 0;
        int n = nums.length;
        int l = 0;
        long res = 0l;
        
        for(int i = 0; i < n; i++){
            if(nums[i] == max){
                maxCount++;

                if(maxCount == k){
                    res += n - i;

                    while(nums[l] != max){
                        res += n - i;
                        l++;
                    }

                    l++;
                    maxCount--;
                }
            }
        }

        return res;
    }
}