class Solution {

    public int[][] specialGrid(int N) {
        int gridSide = 1 << N; // 2^N
        int[][] out = new int[gridSide][gridSide];
        special(out, 0, 0, gridSide, 0);
        return out;
    }

    private void special(int[][] grid, int r, int c, int gridSide, int from) {
        if (gridSide == 1) {
            grid[r][c] = from;
        } else {
            // gridSide = 2 ^ n
            // step = 4 ^ (n - 1) = 2 ^ (2 * (n - 1)) = 2 ^ (2 * n - 2) 
            // = 2 ^ (2 * n) / 2 ^ 2 = (2 ^ n * 2 ^ n) / 4
            int step = (gridSide * gridSide) / 4;
            int halfSide = gridSide / 2; // gridSide divided by 2
            int cRight = c + halfSide;
            int rDown = r + halfSide;
            // Top right has smallest numbers
            special(grid, r, cRight, halfSide, from);
            // Bottom right has next smallest
            special(grid, rDown, cRight, halfSide, from + step);
            // Bottom left has next smallest
            special(grid, rDown, c, halfSide, from + (step * 2));
            // Top left has largest
            special(grid, r, c, halfSide, from + (step * 3));
        }
    }

}