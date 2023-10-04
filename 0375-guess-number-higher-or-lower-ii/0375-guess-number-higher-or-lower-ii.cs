public class Solution {
    public int GetMoneyAmount(int n) {
        int[ , ] dp = new int[n+1, n+1];
        
        //to self cost: 0
        for(int i = 1; i < n+1; i++){
            dp[i, i] = 0;
        }
        //to next cost: self value
        for(int i = 1; i < n; i++){
            dp[i, i+1] = i;
        }
        
        //cost[i, j] = pivot + max(dp[i, pivot - 1], dp[pivot + 1, j])
        //pivot range: (i, j) (exclusive)
        for(int len = 2; len <= n; len++){
            
            for(int i = 1; i < n - len + 1; i++){
                int res = int.MaxValue;
                for(int pivot = i + 1; pivot < i + len; pivot++){
                    
                    //find the worst cost: choose the worse pathway of each pivot
                    int curr = pivot + Math.Max(dp[i, pivot - 1], dp[pivot + 1, i + len]);
                    
                    //play optimally: choose the best pivot
                    res = Math.Min(res, curr);
                }
                dp[i, i + len] = res;
            }
        }
        
        //from the very start to the very end
        //well 1 might NOT be the root and n is a leaf but might NOT be at the 
        return dp[1, n];
    }
}