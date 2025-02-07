class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count = Math.max(dfs(i, j, grid, 0, directions), count);
                }
            }
        }

        return count;
    }

    private int dfs(int i, int j, int[][] grid, int count, int[][] directions){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            count++;

            for(int[] d : directions){
                count = dfs(i + d[0], j + d[1], grid, count, directions);
            }
        }

        return count;
    }
}