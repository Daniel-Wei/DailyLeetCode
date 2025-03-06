class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] map = new int[(int)Math.pow(n, 2) + 1];
        int[] res = new int[2];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[grid[i][j]] == 1){
                    res[0] = grid[i][j];
                }else{
                    map[grid[i][j]] = 1;
                }
            }
        }

        for(int i = 1; i < map.length; i++){
            if(map[i] == 0){
                res[1] = i;
                break;
            }
        }

        return res;
    }
}