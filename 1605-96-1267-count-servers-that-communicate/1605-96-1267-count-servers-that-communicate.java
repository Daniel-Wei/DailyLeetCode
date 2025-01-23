class Solution {
    public int countServers(int[][] grid) {
        int total = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] rowMemo = new int[m];
        int[] colMemo = new int[n];
        List<int[]> list = new ArrayList<int[]>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    rowMemo[i]++;
                    colMemo[j]++;
                    list.add(new int[] {i, j});
                }
            }
        }

        for(int[] computer : list){
            if(rowMemo[computer[0]] > 1 || colMemo[computer[1]] > 1){
                total++;
            }
        }

        return total;
    }

   
}