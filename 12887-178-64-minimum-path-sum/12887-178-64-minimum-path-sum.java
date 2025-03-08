class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int prev = Integer.MAX_VALUE;
                dp[i][j] = grid[i][j];

                if(i - 1 >= 0){
                    prev = Math.min(prev, dp[i - 1][j]);
                }

                if(j - 1 >= 0){
                    prev = Math.min(prev, dp[i][j - 1]);
                }

                if(prev != Integer.MAX_VALUE){
                    dp[i][j] += prev;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}