class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0;
        int l = -1;
        int lastValid = -1;

        for(int r = 0; r < nums.length; r++){
            int num = nums[r];

            if(num > right){
                l = r;
            }else if(num < left){
                // l could be larger than lastValid
                // example: [2, 3, 1, 2], left = 2, right = 2
                // at index 2, l = 1, lastValid = 0
                result += Math.max(lastValid - l, 0);
            }else{
                result += r - l;
                lastValid = r;
            }
        }

        return result;
    }
}