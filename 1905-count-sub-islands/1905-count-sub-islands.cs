public class Solution {
    public int CountSubIslands(int[][] grid1, int[][] grid2){
        int subIslands = 0;
        for (int r = 0; r < grid2.Length; r++)
            for (int c = 0; c < grid2[r].Length; c++)
                if (grid2[r][c] == 1 && SinkSubIsland(grid1, grid2, r, c))
                    subIslands++;
        return subIslands;
    }
	
    private bool SinkSubIsland(int[][] grid1, int[][] grid2, int r, int c){
        if (r < 0 || c < 0 || r >= grid2.Length || c >= grid2[r].Length || grid2[r][c] == 0){return true;}
		
        grid2[r][c] = 0;
        bool stillASubIsland=true;
		
        stillASubIsland &= SinkSubIsland(grid1, grid2, r - 1, c);
        stillASubIsland &= SinkSubIsland(grid1, grid2, r, c + 1);
        stillASubIsland &= SinkSubIsland(grid1, grid2, r + 1, c);
        stillASubIsland &= SinkSubIsland(grid1, grid2, r, c - 1);
        return stillASubIsland & grid1[r][c] == 1;
    }
}