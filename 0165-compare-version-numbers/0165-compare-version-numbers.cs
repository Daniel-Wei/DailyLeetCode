public class Solution {
    public int CompareVersion(string version1, string version2) {
        int[] v1 = Array.ConvertAll(version1.Split('.'), s => int.Parse(s));
        int[] v2 = Array.ConvertAll(version2.Split('.'), s => int.Parse(s));
        
        int p = Math.Min(v1.Length, v2.Length);
        
        for(int i = 0; i < p; i++){
            if(v1[i] < v2[i]){
                return -1;
            }else if(v1[i] > v2[i]){
                return 1;
            }
        }
        
        if(v1.Length > v2.Length){
            for(int i = p; i < v1.Length; i++){
                if(v1[i] != 0){
                    return 1;
                }
            }
        }else if(v2.Length > v1.Length){
            for(int i = p; i < v2.Length; i++){
                if(v2[i] != 0){
                    return -1;
                }
            }
        }
        
        return 0;
    }
}