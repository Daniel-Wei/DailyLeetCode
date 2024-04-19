public class Solution {
    public int NumIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.Length; i++){
            for(int j = 0; j < grid[0].Length; j++){
                if(grid[i][j] == '1'){
                    res += 1;
                    Helper(i, j, grid);
                }
            }
        }
        
        return res;
    }
    
    private void Helper(int i, int j, char[][]grid){
        if(grid[i][j] == '1'){
            grid[i][j] = '0';
        
            if(i + 1 < grid.Length){
                Helper(i + 1, j, grid);
            }

            if(i - 1 >= 0){
                Helper(i - 1, j, grid);
            }

            if(j + 1 < grid[0].Length){
                Helper(i, j + 1, grid);
            }

            if(j - 1 >= 0){
                Helper(i, j - 1, grid);
            }
        }
    }
    
}