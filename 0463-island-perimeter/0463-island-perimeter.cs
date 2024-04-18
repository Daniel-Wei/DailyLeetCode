public class Solution {
    public int IslandPerimeter(int[][] grid) {
        int res = 0;
        int rowNum = grid.Length;
        int colNum = grid[0].Length;
        for(int i = 0; i < rowNum; i++){
            int[]row = grid[i];
            for(int j = 0; j < colNum; j++){
                
                if(row[j] == 1){
                    
                    if((i - 1 >= 0 && grid[i - 1][j] != 1) || i == 0){
                        res += 1;
                    }
                    
                    if(i + 1 == rowNum || (i + 1 < rowNum && grid[i+1][j] != 1)){
                        res += 1;
                    }
                    
                    if(j == colNum - 1 || (j + 1 < colNum && row[j + 1] != 1)){
                        res += 1;
                    }
                    
                    if(j == 0 || (j - 1 >= 0 && row[j - 1] != 1)){
                        res += 1;
                    }
                }
            }
            
            // Console.WriteLine(res);
            // Console.WriteLine();
        }
        
        return res;
    }
}