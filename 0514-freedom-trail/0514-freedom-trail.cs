public class Solution {
    public int FindRotateSteps(string ring, string key) {
        int n = ring.Length;
        int m = key.Length;
        int[,]dp = new int[m+1, n];
        
        for(int i = m-1; i >=0; i--){
            for(int j =0; j < n; j++){
                dp[i,j] = int.MaxValue;
                
                for(int k = 0; k < n; k++){
                    if(ring[k] == key[i]){
                        int diff = Math.Abs(j - k);
                        int step = Math.Min(diff, n - diff);
                        dp[i,j] = Math.Min(dp[i, j], dp[i+1, k] + step);
                    }
                }
            }
        }
        
        
        
        return dp[0,0] + m;
    }
}