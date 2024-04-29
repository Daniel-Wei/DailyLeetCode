class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor ^= nums[i];
        }
        xor ^= k;
        int count = 0;
        while (xor > 0) {
            if (xor % 2 == 1) count++;
            xor = xor >> 1;
        }

        return count;
    }
}
