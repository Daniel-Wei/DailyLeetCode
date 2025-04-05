class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = (int)Math.pow(n, 2);
        boolean[][] visited = new boolean[n][n];
        visited[n - 1][0] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        int steps = 0;
        
        q.offer(1);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int curr = q.poll();
                if(curr == target){
                    return steps;
                }

                for(int next = curr + 1; next <= Math.min(curr + 6, target); next++) {
                    int row = n - 1 - (next - 1) / n;
                    int col = (next + n - 1) % n;

                    
                    // right to left
                    if(((next - 1) / n) % 2 == 1){
                        if(next % n == 0){
                            col = 0;
                        }else{
                            col = n - next % n;
                        }
                    }

                    if(!visited[row][col]){
                        visited[row][col] = true;
                        
                        if(board[row][col] != -1){
                            q.offer(board[row][col]);
                        }else{
                            q.offer(next);
                        }
                    }
                }

            }

            steps++;
        }

        return -1;
    }
}