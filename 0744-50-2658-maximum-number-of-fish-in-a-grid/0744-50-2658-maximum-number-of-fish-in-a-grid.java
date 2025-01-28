class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] directions = new int[] {-1,0,1,0,-1};
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] > 0){
                    res = Math.max(group(i, j, directions, grid, 0), res);
                }
            }
        }

        return res;
    }

    public int group(int i, int j, int[] directions, int[][] grid, int curr){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return curr;
        }

        curr += grid[i][j];
        grid[i][j] = 0;

        for(int k = 0; k < 4; k++){
            curr = group(i + directions[k], j + directions[k + 1], directions, grid, curr);
        }

        return curr;
    }
}