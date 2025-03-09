class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int start = n;

        for(int i = 0; i < n; i++){
            if(nums[i] < k){
                start = i;
                break;
            }
        }

        if(start == n){
            return 0;
        }

        int res = 1;
        int prevCount = 1;
        int prevSum = nums[start];

        for(int i = start + 1; i < n; i++){

            if(nums[i] >= k){
                start = i + 1;
                prevSum = 1;
                prevCount = 0;
                continue;
            }
            
            if(prevSum * nums[i] < k){
                res += prevCount;
                res++;
                prevCount++;
                prevSum *= nums[i];
            }else{
                int curr = prevSum * nums[i];

                while(curr >= k){
                    curr /= nums[start];
                    start++;
                }

                prevCount = i - start + 1;

                res += prevCount;
                prevSum = curr;
               
            }
        }

    

        return res;
    }
}