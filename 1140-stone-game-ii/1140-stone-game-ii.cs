public class Solution {
    private int n;
    private int[ , ] dp;
    private int[] sums;
    private int[] piles;
    
    public int StoneGameII(int[] piles) {
        this.n = piles.Length;
        this.dp = new int[n, n];
        this.sums = new int[n];
        this.piles = piles;
        
        sums[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i--){
            sums[i] = sums[i + 1] + piles[i];
        }
        
        return helper(0, 1);
    }
    
    public int helper(int i, int m){
        
        
        if(i + m * 2 >= n){
            return this.sums[i];
        }
        
        if(this.dp[i, m] != 0){
            return this.dp[i, m];
        }
        
        int min = int.MaxValue;
        
        for(int x = 1; x <= 2 * m; x++){
            if(i + x < n){
                 min = Math.Min(min, helper(i+x, Math.Max(x, m)));
            }
        }
        
        this.dp[i, m] = this.sums[i] - min;
        return this.dp[i, m];
    }
}