public class Solution {
    public int UniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.Length;
        int m = obstacleGrid[0].Length;
        int[,] dp = new int[n, m];
        
        if(obstacleGrid[0][0] == 1){
            dp[0, 0] = 0;
        }else{
            dp[0, 0] = 1;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(obstacleGrid[i][j] != 1){
                    if(i - 1 >= 0){
                        dp[i,j] += dp[i-1, j];
                    }
                    if(j - 1 >= 0){
                        dp[i, j] += dp[i, j - 1];
                    }
                }
            }
        }
        
        return dp[n-1, m-1];
    }
}