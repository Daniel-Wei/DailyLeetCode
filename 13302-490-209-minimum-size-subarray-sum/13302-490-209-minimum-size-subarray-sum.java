class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;
        
        while(right < n){

            // System.out.println(left);
            // System.out.println(right);
            // System.out.println(currSum);
            // System.out.println();

            if(currSum < target){
                currSum += nums[right];
                right++;
            }else{
                
                while(currSum >= target){
                    currSum -= nums[left];
                    left++;
                }
                minLength = Math.min(minLength, right - left + 1);
            }
        }

        if(currSum >= target){
            while(currSum >= target){
                currSum -= nums[left];
                left++;
            }
            minLength = Math.min(minLength, right - left + 1);
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}