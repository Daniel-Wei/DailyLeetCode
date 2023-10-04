public class Solution {
    public int GetMoneyAmount(int n) {
        int[ , ] dp = new int[n+1, n+1];
        
        for(int i = 1; i < n+1; i++){
            dp[i, i] = 0;
        }
        
        for(int i = 1; i < n; i++){
            dp[i, i+1] = i;
        }
        
        for(int len = 2; len <= n; len++){
            for(int i = 1; i < n - len + 1; i++){
                int res = int.MaxValue;
                for(int pivot = i + 1; pivot < i + len; pivot++){
                    int curr = pivot + Math.Max(dp[i, pivot - 1], dp[pivot + 1, i + len]);
                    res = Math.Min(res, curr);
                }
                dp[i, i + len] = res;
            }
        }
        
        return dp[1, n];
    }
}