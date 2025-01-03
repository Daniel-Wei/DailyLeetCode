class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        long[] prefixSum = new long[n - 1];
        long sum = 0;

        for(int i = 0; i < n - 1; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }

        sum += nums[n - 1];

        double half = (double) sum / 2;
        int res = 0;

        for(long prefix : prefixSum){
            if(prefix >= half){
                res++;
            }
        }

        return res;
    }
}