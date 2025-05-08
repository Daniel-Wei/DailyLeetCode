class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dp = new int[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (dp[a[0]][a[1]] - dp[b[0]][b[1]]));
        pq.offer(new int[] {0, 0});

        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int seconds = 1;


        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int r = curr[0];
            int c = curr[1];

            if((r + c) % 2 == 1){
                seconds = 2;
            }else{
                seconds = 1;
            }

            for(int[] d : directions){
                int nr = d[0] + r;
                int nc = d[1] + c;

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]){
                    int time = Math.max(dp[r][c], moveTime[nr][nc]) + seconds;
                    dp[nr][nc] = time;
                    visited[nr][nc] = true;
                    if(nr == n - 1 && nc == m - 1){
                        return time;
                    }
                    pq.offer(new int[] {nr, nc});
                }
            }
        } 

        return 666;
    }
}