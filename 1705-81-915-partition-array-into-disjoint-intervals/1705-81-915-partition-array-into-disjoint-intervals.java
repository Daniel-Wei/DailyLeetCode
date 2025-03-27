class Solution {
    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] maxFromLeft = new int[n];
        int currMax = -1;
        
        for(int i = 0; i < n; i++) {
            currMax = Math.max(currMax, nums[i]);
            maxFromLeft[i] = currMax;
        }

        int[] minFromRight = new int[n];
        int currMin = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--) {
            currMin = Math.min(currMin, nums[i]);
            minFromRight[i] = currMin;
        }

        int leftPartitionLength = 0;

        for(int i = 0; i < n - 1; i++) {
            if(maxFromLeft[i] <= minFromRight[i + 1]){
                leftPartitionLength = i + 1;
                break;
            }
        }

        return leftPartitionLength;

    }
}