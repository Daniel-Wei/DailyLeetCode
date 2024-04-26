public class Solution {
    public int MinFallingPathSum(int[][] matrix) {
         int n = matrix.Length;
        int[,]dp = new int[n, n];
        
        for(int i = 0; i < n; i++){
            dp[0,i] = matrix[0][i];
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                
                
                dp[i, j] = dp[i-1, j];
                
                if(j - 1 >= 0){
                    dp[i, j] = Math.Min(dp[i, j], dp[i-1, j-1]);
                }
                
                if(j + 1 < n){
                    dp[i, j] = Math.Min(dp[i, j], dp[i-1, j+1]);
                }
                
                dp[i,j] += matrix[i][j];
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