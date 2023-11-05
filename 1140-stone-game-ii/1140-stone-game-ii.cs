public class Solution {
    private int n;
    private int[ , ] dp;
    private int[] sums;
    private int[] piles;
    
    public int StoneGameII(int[] piles) {
        n = piles.Length;
        dp = new int[n, n];
        sums = new int[n];
        piles = piles;
        
        sums[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i--){
            sums[i] = sums[i + 1] + piles[i];
        }
        
        return helper(0, 1);
    }
    
    public int helper(int i, int m){
        
        // if could get all the remaining piles
        if(i + m * 2 >= n){
            return sums[i];
        }
        
        //avoid repeated calculations
        if(dp[i, m] != 0){
            return dp[i, m];
        }
        
        //Strategy/ Alice & Bob play optimally: make the next player's files number to be the minimum one
        int min = int.MaxValue;
        for(int x = 1; x <= 2 * m; x++){
            if(i + x < n){
                 min = Math.Min(min, helper(i+x, Math.Max(x, m)));
            }
        }
        
        dp[i, m] = sums[i] - min;
        return dp[i, m];
    }
}