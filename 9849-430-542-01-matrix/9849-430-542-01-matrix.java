class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    res[i][j] = Integer.MAX_VALUE;
                }else{
                    q.offer(new Pair(i, j));
                }
            }
        }

        //Queue makes sure it is level by level
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int row = p.getKey();
            int col = p.getValue();

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && res[newRow][newCol] > res[row][col] + 1) {
                    res[newRow][newCol] = res[row][col] + 1;
                    q.offer(new Pair(newRow, newCol));
                }
            }
        }

        return res;
    }
}