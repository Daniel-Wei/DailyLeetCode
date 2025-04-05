class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d){
            return -1;
        }

        int sum = 0;
        for(int jd : jobDifficulty){
            sum += jd;
        }

        if(sum == 0 || n == d){
            return sum;
        }
        
        int[][] subMax = new int[n][n];

        for(int i = 0; i < n; i++){
            subMax[i][i] = jobDifficulty[i];
            for(int j = i + 1; j < n; j++){
                subMax[i][j] = Math.max(subMax[i][j - 1], jobDifficulty[j]);
            }
        }

        int[][] dp = new int[n][d];

        return helper(0, d, 0, jobDifficulty.length, subMax, dp);
    }

    private int helper(int cuts, int d, int lastCut, int n, int[][] subMax, int[][] dp){

        if(dp[lastCut][cuts] != 0){
            return dp[lastCut][cuts];
        }


        if(cuts == d - 1){
            dp[lastCut][cuts] = subMax[lastCut][n - 1];
            return dp[lastCut][cuts];
        }

        int minMaxSum = Integer.MAX_VALUE;

        for(int i = lastCut + 1; i <= n - d + 1 + cuts; i++) {

            int currMaxSum = subMax[lastCut][i - 1];

            currMaxSum += helper(cuts + 1, d, i, n, subMax, dp);

            minMaxSum = Math.min(currMaxSum, minMaxSum);
        }

        dp[lastCut][cuts] = minMaxSum;

        return minMaxSum;
    }
}