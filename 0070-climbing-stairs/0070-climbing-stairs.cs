public class Solution {
    public int ClimbStairs(int n) {
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
            return 2;
        }
        
        
        int[]memo = new int[n+1];
        memo[1] = 1;
        memo[2] = 2;
        
        for(int i = 3; i < n + 1; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        
        return memo[n];
    }
}