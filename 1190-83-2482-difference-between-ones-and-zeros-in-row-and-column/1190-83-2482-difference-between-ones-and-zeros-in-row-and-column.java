class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];

        int[][] diff = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                diff[i][j] = 2 * onesRow[i] + 2 * onesCol[j] - m - n;
            }
        }

        return diff;
    }
}