class Solution {
    public void solve(char[][] board) 
    {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            
            if(!visited[i][0] && board[i][0] == 'O') {
                dfs(board, i, 0, directions, visited);
            }

            if(!visited[i][n-1] && board[i][n - 1] == 'O') {
                dfs(board, i, n - 1, directions, visited);
            }
        }

        for(int j = 0; j < n; j++) {
            if(!visited[0][j] && board[0][j] == 'O') {
                dfs(board, 0, j, directions, visited);
            }

            if(!visited[m - 1][j] && board[m - 1][j] == 'O') {
                dfs(board, m - 1, j, directions, visited); 
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }	
    }

    private void dfs(char[][] board, int i, int j, int[][] directions, boolean[][] visited) {
        visited[i][j] = true;

        for(int[] d: directions) {
            int row = i + d[0];
            int col = j + d[1];

            if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 'O' && !visited[row][col]) {
                dfs(board, row, col, directions, visited);
            }
        }
    }

}