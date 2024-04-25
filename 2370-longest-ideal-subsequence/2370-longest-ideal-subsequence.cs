public class Solution {
    public int LongestIdealString(string s, int k) {
        int[]dp = new int[26];
        
        foreach(char c in s){
            int i = c - 'a';
            
            int start = Math.Max(0, i - k);
            int end = Math.Min(25, i + k);
            
            for(int j = start; j <= end; j++){
                dp[i] = Math.Max(dp[i], dp[j]);
            }
            
            dp[i] += 1;
        }
        
        return dp.Max();
    }
}