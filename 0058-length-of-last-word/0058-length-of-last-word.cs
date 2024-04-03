public class Solution {
    public int LengthOfLastWord(string s) {
        s = s.Trim();
        int res = s.Length;
        
        for(int i = s.Length - 1; i >= 0; i--){
            if(s[i] == ' '){
                res -= (i + 1);
                break;
            }
        }
        
        return res;
    }
}