class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        
        int[] sums = new int[n];
        sums[n-1] = piles[n - 1];
        
        // sum[i]: sum(piles[i:]) inclusively
        for(int i = n - 2; i >= 0; i--){
            sums[i] = sums[i + 1] + piles[i];
        }        
        int[][]dp = new int[n][n];
        
        return helper(0, 1, dp, sums, n);
        
        
    }
    
    private int helper(int i, int m, int[][] dp, int[] sums, int n){
        
        // not 'i + 2m >= n - 1' as i-th is the actual start of 2m
        if(i + 2 * m >= n){
            return sums[i];
        }
        
        if(dp[i][m] != 0){
            return dp[i][m];
        }
        
        int min = Integer.MAX_VALUE;
        
        // k <= 2m && i + k <= n - 1
        for(int k = 1; k <= Math.min(2 * m, n - i - 1); k++){
            min = Math.min(min, helper(i + k, Math.max(k, m), dp, sums, n));
        }
        
        dp[i][m] = sums[i] - min;
        
        return dp[i][m];
    }
}