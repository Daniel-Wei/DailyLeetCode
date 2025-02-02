class Solution {
    public boolean check(int[] nums) {
        int numOfNonDecreasing = 1;
        int firstStart = nums[0];
        int secondEnd = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < nums[i - 1]){
                numOfNonDecreasing++;
                if(numOfNonDecreasing > 2){
                    return false;
                }
            }
        }

        return numOfNonDecreasing == 1 || firstStart >= secondEnd;
    }
}