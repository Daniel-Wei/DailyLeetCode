class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[]dp = new long[n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[j] += points[i][j];
            }
            
            // at each row i
            // dp[j] means the max possible value in col j, not necessarily means points[i][j] is selected
            // example: [1, 2, 3], [1, 5, 1] -> [6, 7, 6]
            // those two 6s means: 5 + 3 - 1 - 1
            
            
            //left to right
            //dp[j] = Math.max(dp[j], Math.max(for k < j, dp[k] - (j - k)))
            for(int j = 1; j < n; j++){
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            
            //right to left
            //dp[j] = Math.max(dp[j], Math.max(for k > j, dp[k] - (k - j)))
            for(int j = n - 2; j >= 0; j--){
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        
        long res = dp[0];
        
        for(int i = 1; i < n; i++){
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
}