class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] paintedRows = new int[m];
        int[] paintedCols = new int[n];
        int res = -1;
        int row = -1;
        int col = -1;

        HashMap <Integer, Pair<Integer, Integer>> hm = new HashMap<Integer, Pair<Integer, Integer>>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                hm.put(mat[i][j], new Pair(i, j));
            }
        }

        for(int i = 0; i < arr.length; i++){
            Pair<Integer, Integer> pair = hm.get(arr[i]);
            row = pair.getKey();
            col = pair.getValue();
            paintedRows[row]++;
            paintedCols[col]++;

            // specific row: number of painted cells == number of cols
            // specific col: number of painted cells == number of rows
            if(paintedRows[row] == n || paintedCols[col] == m){
                res = i;
                break;
            }
        }

        return res;
    }
}