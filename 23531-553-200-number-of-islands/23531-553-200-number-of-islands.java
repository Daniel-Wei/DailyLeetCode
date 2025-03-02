class Solution {
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid, directions);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] grid, int[][] directions){
        grid[i][j] = '0';

        for(int[] d : directions){
            int r = i + d[0];
            int c = j + d[1];

            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1'){
                dfs(r, c, grid, directions);
            }
        }
        
    }
    
    
}