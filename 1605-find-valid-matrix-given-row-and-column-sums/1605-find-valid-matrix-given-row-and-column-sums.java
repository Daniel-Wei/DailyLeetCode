class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int M = rowSum.length;
        int N = colSum.length;
        int[][] m = new int[M][N];
        int i = 0;
        int j = 0;
        
        while(i < M && j < N){
            int curr = Math.min(rowSum[i], colSum[j]);
            m[i][j] = curr;
            rowSum[i] -= curr;
            colSum[j] -= curr;
            
            if(rowSum[i] == 0){
                i++;
            }else{
                j++;
            }
        }
        
        return m;
    }
}