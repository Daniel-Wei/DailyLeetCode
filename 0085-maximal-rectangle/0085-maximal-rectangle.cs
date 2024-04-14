public class Solution {
    public int MaximalRectangle(char[][] matrix) {
        List<List<int>> dp = new List<List<int>>();
        int l = matrix[0].Length;
        int i = 0;
        int j = 0;
        int res = 0;
        
        foreach(char[] m in matrix){
            foreach(List<int>r in dp){
                int start = r[0];
                int end = r[1];
                
                if(start != -1){
                     for(int k = start; k <= end; k++){
                        if(m[k] != '1'){
                            if(k == start){
                                r[0] = -1;
                            }else{
                                r[2] ++;
                                r[1] = k - 1;
                            }
                            break;
                        }

                        if(k == end){
                            r[2] ++;
                        }
                    }
                }
                
            }
            
            i = 0;
            j = 0;
            
            while(i < l){
                if(m[i] == '0'){
                    i++;
                }else{
                    j = i;
                    while(j < l){
                        j++;
                        
                        if(j == l || m[j] == '0'){
                            dp.Add(new List<int>{i, j - 1, 1});
                            break;
                        }
                    }
                    i++;
                }
            }
            
            foreach(List<int> r in dp){
                if(r[0] != -1){
                    res = Math.Max(res, r[2] * (r[1] - r[0] + 1));
                }
                
                // Console.WriteLine(r[0]);
                // Console.WriteLine(r[1]);
                // Console.WriteLine(r[2]);
                // Console.WriteLine();
                
            }
//             Console.WriteLine("***");
            
            
//             Console.WriteLine(res);
            
//             Console.WriteLine("---------");

        }
        
        
        
        return res;
    }
}