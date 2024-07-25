class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for(int i = 1; i < n; i++){
            int curr = nums[i];
            
            int j = i;
            while(j > 0 && curr < nums[j - 1]){
                nums[j] = nums[j-1];
                j--;
            }
            
            nums[j] = curr;
        }
        return nums;
    }
}