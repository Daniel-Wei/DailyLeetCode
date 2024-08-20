class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        int currSum = 0;
        
        for(int i = 0; i < n; i++){
            currSum += piles[i];
            
            dp[i][i] = piles[i];
            
            for(int j = i - 1; j >= 0; j--){
                dp[j][i] = currSum - Math.min(dp[j][i - 1], dp[j + 1][i]);
            }
        }
        
        return  2 * dp[0][n - 1] > currSum;
    }
}