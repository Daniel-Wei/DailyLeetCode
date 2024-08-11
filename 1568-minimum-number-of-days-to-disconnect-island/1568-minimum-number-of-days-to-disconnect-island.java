class Solution {
    public int minDays(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        //Initial Tests
        int count = islandNumbers(grid, new int[r][c]);
        if(count == 0 || count == 2){
            return 0;
        }
        
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    int num = islandNumbers(grid, new int[r][c]);
                    if(num != 1){
                        return 1;
                    }
                    
                    grid[i][j] = 1;
                }
            }
        }
        
        return 2;
    }
    
    private int islandNumbers(int[][]grid, int[][]searched){
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && searched[i][j] == 0){
                    if(count == 0){
                        count++;
                        dfs(grid, i, j, searched);
                    }else{
                        return 2;
                    }
                }
            }
        }
        
        return count;
    }
    
    private void dfs(int[][]grid, int r, int c, int[][]searched){
        searched[r][c] = 1;
        if(r < grid.length - 1 && grid[r + 1][c] == 1 && searched[r + 1][c] == 0){
            searched[r + 1][c] = 1;
            dfs(grid, r + 1, c, searched);
        }
        
        if(r > 0 && grid[r - 1][c] == 1 && searched[r - 1][c] == 0){
            searched[r - 1][c] = 1;
            dfs(grid, r - 1, c, searched);
        }
        
        if(c < grid[0].length - 1 && grid[r][c + 1] == 1 && searched[r][c + 1] == 0){
            searched[r][c + 1] = 1;
            dfs(grid, r, c + 1, searched);
        }
        
        if(c > 0 && grid[r][c - 1] == 1 && searched[r][c - 1] == 0){
            searched[r][c - 1] = 1;
            dfs(grid, r, c - 1, searched);
        }
    }
}