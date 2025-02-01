class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean parity = nums[0] % 2 == 1;

        for(int num : nums){
            boolean curr = num % 2 == 0;

            if(curr == parity){
                return false;
            }else{
                parity = curr;
            }
        }

        return true;
    }
}