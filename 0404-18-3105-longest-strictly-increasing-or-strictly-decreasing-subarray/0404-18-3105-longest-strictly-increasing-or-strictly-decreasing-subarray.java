class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1;
        int maxIncreasing = 1;
        int decreasing = 1;
        int maxDecreasing = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                increasing++;
                maxDecreasing = Math.max(decreasing, maxDecreasing);
                decreasing = 1;
            }else if(nums[i] < nums[i - 1]){
                decreasing++;
                maxIncreasing = Math.max(maxIncreasing, increasing);
                increasing = 1;
            }else{
                maxDecreasing = Math.max(decreasing, maxDecreasing);
                decreasing = 1;
                maxIncreasing = Math.max(maxIncreasing, increasing);
                increasing = 1;
            }
        }

        maxDecreasing = Math.max(maxDecreasing, decreasing);
        maxIncreasing = Math.max(maxIncreasing, increasing);

        return Math.max(maxIncreasing, maxDecreasing);

    }
}