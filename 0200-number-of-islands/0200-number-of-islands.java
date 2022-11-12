class Solution {
    private int m;
    private int n;
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j]=='1'){
                    ans += 1;
                    dfs(grid, i, j);
                }
            }
        }
        
        return ans;
        
        
    }
    
    private void dfs(char[][] grid, int i, int j){
        boolean condition = i >= 0 && i < m && j >= 0 && j < n && grid[i][j]=='1';
        
        if(condition){
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
        
    }
}