public class Solution {
    public bool PredictTheWinner(int[] nums) {
        int n = nums.Length;
        int totalSum = nums.Sum();
        int start = 0;
        int end = n - 1;
        
        int[ , ]dp = new int[n, n];
        
        
        for(int i = 0; i < n; i++){
            int currSum = nums[i];
            for(int j = i; j >= 0; j--){
                
                if(i == j){
                    dp[i, i] = nums[i];
                    
                }else{
                    currSum += nums[j];
                    dp[j, i] = Math.Max(currSum - dp[j + 1, i], currSum - dp[j, i - 1]);
                }
                
                
                
            }
        }
        
     
      
        
        return 2 * dp[0, n - 1] >= totalSum;
        
       
        
    
    }
    
   
}