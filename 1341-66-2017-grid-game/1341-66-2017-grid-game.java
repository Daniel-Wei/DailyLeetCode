class Solution {
    
    /*
        Maximizing path for robot 1 doesn't ensure the solution. Hence dp won't work here.
        Example: [[5,12,14],[20,7,17]]
    */
    
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] row1PrefixSum = new long[n];
        long row2PrefixSum = 0;
        
        row1PrefixSum[0] = grid[0][0];

        for(int i = 1; i < n; i++){
            row1PrefixSum[i] = row1PrefixSum[i - 1] + grid[0][i];
        }

        long res = row1PrefixSum[n - 1] - row1PrefixSum[0];

        // If Robot 1 goes down at index i
        for(int i = 1; i < n; i++){
            row2PrefixSum += grid[1][i - 1];

            // Robot 2 either takes row 1[i + 1, n - 1] or row2 [0, i - 1];
            long p2CurrMax = Math.max(row1PrefixSum[n - 1] - row1PrefixSum[i], row2PrefixSum);

            // Robot 1 take the index i where tha maximum points Robot 2 can get is minimized
            res = Math.min(res, p2CurrMax);
        }

        return res;
    }
}