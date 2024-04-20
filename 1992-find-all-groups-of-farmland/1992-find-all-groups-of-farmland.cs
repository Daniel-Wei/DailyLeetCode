public class Solution {
    public int[][] FindFarmland(int[][] land) {
        List<int[]> res = new List<int[]>();
        
        for(int i = 0; i < land.Length; i++){
            for(int j = 0; j < land[0].Length; j++){
                if(land[i][j] == 1){
                    Helper(land, i, j, res);
                    // Helper(land, i, j, new int[]{i, j}, new int[]{i, j}, res);
                }
            }
        }
        return res.ToArray();
    }
    
    private void Helper(int[][]land, int i, int j, List<int[]>res){
        int[]curr = new int[4];
        
        curr[0] = i;
        curr[1] = j;
        
        int k = i;
        int m = j;
        
        while(k < land.Length && land[k][j] == 1){
            k++;
        }
        
        while(m < land[0].Length && land[i][m] == 1){
            m++;
        }
        
        curr[2] = k - 1;
        curr[3] = m - 1;
        
        res.Add(curr);
        
        for(int row = i; row < k; row++){
            for(int col = j; col < m; col++){
                land[row][col] = 0;
            }
        }
    }
    
    //Stack Overflow
//     private bool Helper(int[][]land, int i, int j, int[]start, int[]end, List<int[]> res){
//         bool check = false;
        
//         land[i][j] = 0;

//         if(i <= start[0] && j <= start[1]){
//             start[0] = i;
//             start[1] = j;
//         }

//         if(i >= end[0] && j >= end[1]){
//             end[0] = i;
//             end[1] = j;
//         }

//         if(i - 1 >= 0 && land[i - 1][j] == 1){
//             check = check || Helper(land, i - 1, j, start, end, res);
//         }

//         if(i + 1 < land.Length && land[i + 1][j] == 1){
//             check = check || Helper(land, i + 1, j, start, end, res);
//         }

//         if(j - 1 >= 0 && land[i][j-1] == 1){
//             check = check || Helper(land, i, j - 1, start, end, res);
//         }

//         if(j + 1 < land[0].Length && land[i][j + 1] == 1){
//             check = check || Helper(land, i, j + 1, start, end, res);
//         }

//         if(!check){
//             res.Add(new int[]{start[0], start[1], end[0], end[1]});
//             check = true;
//         }
        
//         return check;
//     }
}