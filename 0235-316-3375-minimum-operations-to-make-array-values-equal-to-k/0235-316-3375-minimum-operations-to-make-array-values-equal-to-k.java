class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[0] < k) {
            return -1;
        }

        int i = nums.length - 2;
        int operations = nums[0] > k ? 1 : 0;

        while(i >= 0) {
            if(nums[i] != nums[i+1]) {
                operations++;
            }

            i--;
        }

        return operations;

    }
}