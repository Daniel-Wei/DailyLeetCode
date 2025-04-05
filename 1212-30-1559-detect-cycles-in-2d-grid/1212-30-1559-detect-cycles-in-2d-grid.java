class Solution {
    public boolean containsCycle(char[][] grid) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    if(dfs(grid[i][j], visited, grid, directions, i, j, -1, -1)){
                        return true;
                    }
                }
            }
        }

        return false;
       
    }

    private boolean dfs(char c, boolean[][] visited, char[][] grid, 
        int[][] directions, int row, int col, int prevRow, int prevCol) 
    {
        
        for(int[] d : directions){
            int newRow = row + d[0];
            int newCol = col + d[1];

            if(newRow >= 0 && newRow < grid.length 
                && newCol >= 0 && newCol < grid[0].length
                && grid[newRow][newCol] == c)
            {
                if(newRow == prevRow && newCol == prevCol){
                    continue;
                }

                if(visited[newRow][newCol]){
                    return true;
                }

                visited[newRow][newCol] = true;
                
                if(dfs(c, visited, grid, directions, newRow, newCol, row, col)){
                    return true;
                }
            }
        }

        return false;
    }
}