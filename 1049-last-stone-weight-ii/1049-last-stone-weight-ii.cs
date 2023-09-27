public class Solution {
    public int LastStoneWeightII(int[] stones) {
        
        HashSet<int>[] dp = new HashSet<int>[stones.Length];
        dp[0] = new HashSet<int>();
        dp[0].Add(stones[0]);
      
        for(int i = 1; i < stones.Length; i++){
            dp[i] = new HashSet<int>();
            int curr = stones[i];
            
            foreach(int sum in dp[i - 1]){
                dp[i].Add(Math.Abs(curr - sum)); //Add to the group of stones[0]
                dp[i].Add(Math.Abs(curr + sum)); //Not add to the group of stones[0]
            };
        }
        
        return dp[stones.Length - 1].Min();
       
    }
}