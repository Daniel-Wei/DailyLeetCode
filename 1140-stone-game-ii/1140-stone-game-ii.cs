public class Solution {
    public int StoneGameII(int[] piles) {
        int n = piles.Length;
        int m = n / 2;
        int[, ] dp = new int[n, n];
        
        int[] sums = new int[n];
        
        sums[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i--){
            sums[i] = sums[i + 1] + piles[i];
        }
        
        return helper(0, 1, dp, piles, sums);
    }
    
    public int helper(int i, int m, int[,] dp, int[]piles, int[]sums){
        if(i == piles.Length){
            return 0;
        }
        
        if(i + m * 2 >= piles.Length){
            return sums[i];
        }
        
        if(dp[i, m] != 0){
            return dp[i, m];
        }
        
        int min = int.MaxValue;
        
        for(int x = 1; x <= 2 * m; x++){
            min = Math.Min(min, helper(i+x, Math.Max(x, m), dp, piles, sums));
        }
        
        dp[i, m] = sums[i] - min;
        return dp[i, m];
            
            
        
    }
    
    
}