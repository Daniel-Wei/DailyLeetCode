public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        int minD = difficulty.Min();
        int maxD = difficulty.Max();
        int maxP = profit.Max();
        
        int[]dp = new int[maxD + 1];
        
        for(int i = 0; i < profit.Length; i++){
            // There could be multiple same difficulties with different profits.
            dp[difficulty[i]] = Math.Max(dp[difficulty[i]], profit[i]);
        }
        
        for(int i = 1; i < dp.Length; i++){
            dp[i] = Math.Max(dp[i - 1], dp[i]);
        }
        
      
        foreach(int w in worker){
            if(w < minD){
                res += 0;
            }else if(w > maxD){
                res += maxP;
            }else{
                res += dp[w];
            }
        }
        
        return res;
    }
}