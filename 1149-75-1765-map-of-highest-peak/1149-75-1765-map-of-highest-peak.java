class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] res = new int[m][n];

        Queue<Pair<Integer, Integer>> q = new LinkedList<Pair<Integer, Integer>>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    q.offer(new Pair(i, j));
                    res[i][j] = 0;
                }else{
                    res[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int r = p.getKey();
            int c = p.getValue();

            for(int[] d: directions){
                int row = r + d[0];
                int col = c + d[1];

                if(row >= 0 && row < m && col >= 0 && col < n && res[row][col] == -1){
                    res[row][col] = res[r][c] + 1;
                    q.offer(new Pair(row, col));
                }
            }
        }

        return res;
    }
}