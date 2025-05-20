class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] start = new int[n + 1];
        int[] end = new int[n + 1];

        for(int[] q : queries){
            start[q[0]]++;
            end[q[1] + 1]++;
        }

        int started = 0;
        int ended = 0;

        for(int i = 0; i < n; i++){
            started += start[i];
            ended += end[i];

            if(nums[i] - started + ended > 0){
                return false;
            }
        }

        return true;
    }
}