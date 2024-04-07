public class Solution {
    public bool CheckValidString(string s) {
        int[ , ] dp = new int[s.Length, s.Length];
        
        for(int i = 0; i < s.Length; i++){
            
            for(int j = 0; j < s.Length; j++){
                dp[i, j] = -1;
            }
        }
        
        return Helper(s, 0, 0, dp);
        
    }
    
    private bool Helper(string s, int index, int o, int[,]dp){
        
        if(o < 0){
            return false;
        }
        
        if(index == s.Length){
            return o == 0;
        }
        
        if(dp[index, o] != -1){
            return dp[index, o] == 1;
        }
        
        bool isValid = false;
        
        if(s[index] == '('){
            isValid = Helper(s, index + 1, o + 1, dp);
        }
        
        else if(s[index] == ')'){
            isValid =  Helper(s, index + 1, o - 1, dp);
        }
        else{
            isValid = Helper(s, index + 1, o + 1, dp) || Helper(s, index + 1, o - 1, dp)
                || Helper(s, index + 1, o, dp);
        }
        
        
        dp[index, o] = isValid ? 1: 0;
        
        return isValid;
    }
}