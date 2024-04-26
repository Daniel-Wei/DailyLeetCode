public class Solution {
    public int MinFallingPathSum(int[][] grid) {
        int n = grid.Length;
        int[,]dp = new int[n, n];
        
        for(int i = 0; i < n; i++){
            dp[0,i] = grid[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                
                dp[i, j] = int.MaxValue;
                
                for(int k = 0; k < n; k++){
                    if(k != j){
                        dp[i, j] = Math.Min(dp[i, j], dp[i-1, k]);
                    }
                }
                
                dp[i,j] += grid[i][j];
            }
        }
        
        int res = int.MaxValue;
        
        for(int i = 0; i < n; i++){
            // Console.WriteLine(dp[n-1, i]);
            res = Math.Min(res, dp[n-1,i]);
        }
        
        return res;
    }
}