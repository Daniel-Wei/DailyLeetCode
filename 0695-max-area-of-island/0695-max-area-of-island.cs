public class Solution {
    public int MaxAreaOfIsland(int[][] grid) {
        int row = grid.Length;
        int col = grid[0].Length;
        
        int res = 0;
        
        for(int i = 0; i < grid.Length; i++){
            for(int j = 0; j < grid[0].Length; j++){
                if(grid[i][j] == 1){
                    res = Math.Max(Helper(i, j, 0, grid), res);
                }
            }
        }
        
        return res;
    }
    
    private int Helper(int i, int j, int curr, int[][]grid){
        if(grid[i][j] == 0){
            return curr;
        }
        curr += 1;
        
        grid[i][j] = 0;
        
        if(i + 1 < grid.Length){
            curr = Helper(i + 1, j, curr, grid);
        }
        
        if(i - 1 >= 0){
            curr = Helper(i - 1, j, curr, grid);
        }
        
        if(j + 1 < grid[0].Length){
            curr = Helper(i, j + 1, curr, grid);
        }
        
        if(j - 1 >= 0){
            curr = Helper(i, j - 1, curr, grid);
        }
        
        return curr;
    }
}