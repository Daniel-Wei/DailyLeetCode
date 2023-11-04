public class Solution {
    public bool StoneGame(int[] piles) {
        int totalSum = piles.Sum();
        int n = piles.Length;
        int[, ] dp = new int[n, n];
        
        for(int i = 0; i < n; i++){
            int currSum = 0;
            for(int j = i; j >=0; j--){
                currSum += piles[j];
                
                if(i == j){
                    dp[i, i] = piles[i];
                }else{
                    dp[j, i] = Math.Max(currSum - dp[j+1, i], currSum - dp[j, i-1]);
                }
            }
        }
        
        return 2 * dp[1, n-1] < totalSum || 2 * dp[0, n-2] < totalSum;
    }
}