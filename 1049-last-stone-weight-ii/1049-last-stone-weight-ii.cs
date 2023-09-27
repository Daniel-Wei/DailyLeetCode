public class Solution {
    public int LastStoneWeightII(int[] stones) {
        
        HashSet<int>[] dp = new HashSet<int>[stones.Length];
        dp[0] = new HashSet<int>();
        dp[0].Add(stones[0]);
      
        for(int i = 1; i < stones.Length; i++){
            dp[i] = new HashSet<int>();
            int curr = stones[i];
            
            foreach(int sum in dp[i - 1]){
                dp[i].Add(Math.Abs(curr - sum));
                dp[i].Add(Math.Abs(curr + sum));
            };
        }
        
        return dp[stones.Length - 1].Min();
       
    }
}