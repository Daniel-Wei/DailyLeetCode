class Solution {
    public int countServers(int[][] grid) {
        int total = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rowMemo = new int[m];
        int[] colMemo = new int[n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowMemo[i]++;
                    colMemo[j]++;
                }
            }
        }


        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && (rowMemo[i] > 1 || colMemo[j] > 1)){
                    total++;
                }
            }
        }

    
        return total;
    }
   
}