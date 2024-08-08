class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int count = 1;
        int sideLen = 1;
        int sideCount = 0;
        int prevR = 0;
        int prevC = 0;
        int r = rStart;
        int c = cStart;
        int[][] res = new int[rows * cols][2];
        res[0][0] = rStart;
        res[0][1] = cStart;
        
        while(count < rows * cols){
            prevR = r;
            prevC = c;

            if(sideLen % 2 == 1){
                if(sideCount % 3 == 0){
                    c += sideLen;
                }else if(sideCount % 3 == 1){
                    r += sideLen;
                }else{
                    sideCount++;
                    sideLen++;
                    continue;
                }
            }else{
                if(sideCount % 3 == 0){
                    c -= sideLen;
                }else if(sideCount % 3 == 1){
                    r -= sideLen;
                }else{
                    sideCount++;
                    sideLen++;
                    continue;
                }
            }
            

            // Move towards south
            if(prevR < r && c >= 0 && c < cols){
                for(int i = Math.max(prevR + 1, 0); i <= Math.min(r, rows - 1); i++){
                    res[count][0] = i;
                    res[count][1] = c;
                    count++;
                }
            }
            
            // Move towards north
            if(prevR > r && c >= 0 && c < cols){
                for(int i = Math.min(prevR - 1, rows - 1); i >= Math.max(r, 0); i--){
                    res[count][0] = i;
                    res[count][1] = c;
                    count++;
                }
            }
            
            // Move towards east
            if(prevC < c && r >= 0 && r < rows){
                for(int i = Math.max(prevC + 1, 0); i <= Math.min(c, cols - 1); i++){
                    res[count][0] = r;
                    res[count][1] = i;
                    count++;
                }
            }
            
            // Move towards west
            if(prevC > c && r >= 0 && r < rows){
                for(int i = Math.min(prevC - 1, cols - 1); i >= Math.max(c, 0); i--){
                    res[count][0] = r;
                    res[count][1] = i;
                    count++;
                }
            }
            
            sideCount++;
        }
        
        return res;
    }
}