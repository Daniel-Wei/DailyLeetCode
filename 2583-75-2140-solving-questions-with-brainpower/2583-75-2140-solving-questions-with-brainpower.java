class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp= new long[n];
        dp[n - 1] = (long)questions[n - 1][0];
        long currMax = dp[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            int[] q = questions[i];
            long val = (long)q[0];
            int skip = q[1];

            if(i + skip > n - 2) {
                dp[i] = Math.max(currMax, val);
            }else{
                dp[i] = Math.max(currMax, (val + dp[i + skip + 1]));
            }

            currMax = dp[i];
        }

        return currMax;
    }
}