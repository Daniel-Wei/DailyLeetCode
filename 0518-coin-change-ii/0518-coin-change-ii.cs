public class Solution {
    public int Change(int amount, int[] coins) {
        int[,]dp = new int[coins.Length, amount + 1];
        
        for(int i = 0; i < coins.Length; i++){
            //edge cases
            dp[i, 0] = 1;
            
            for(int j = 1 ; j <= amount; j++){
                if(i != 0){
                    // not use coins[i]
                    dp[i, j] += dp[i-1, j];
                }
                
                // use all coins[0...i]
                if(j >= coins[i]){
                    dp[i, j] += dp[i, j - coins[i]];
                }
            }
        }
        
        return dp[coins.Length - 1, amount];
    }
}