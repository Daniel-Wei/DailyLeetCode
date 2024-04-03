public class Solution {
    public bool Exist(char[][] board, string word) {
        int m = board.Length;
        int n = board[0].Length;
        bool result = false;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word[0] == board[i][j]){
                    result = result || BackTrack(board, 0, i, j, m, n, word);
                }
            }
        }
        
        return result;
    }
    
    private bool BackTrack(char[][]board, int index, int row, int col, int m, int n, string word){
        
        //base case
        if(index == word.Length){
            return true;
        }
        
        if(row < 0 || row == m || col < 0 || col == n || board[row][col] == '#'){
            return false;
        }
        
        // debug
        // Console.WriteLine(row);
        // Console.WriteLine(col);
        // Console.WriteLine(index);
        // Console.WriteLine();

        char curr = board[row][col];
        
        board[row][col] = '#';
        
        bool res = true;
        
        if(word[index] != curr){
            res = false;
        }else{
            res =  BackTrack(board, index + 1, row + 1, col, m, n, word) || BackTrack(board, index + 1, row - 1, col, m, n, word)
                || BackTrack(board, index + 1, row, col + 1, m, n, word) || BackTrack(board, index + 1, row, col - 1, m, n, word);
        }
        
        if(!res){
            board[row][col] = curr;
        }
        
        return res;
    }
}