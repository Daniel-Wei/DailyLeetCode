enum RESULT { 
    TRUE,
    FALSE
}
class Solution {

    public boolean isMatch(String text, String pattern) {
        RESULT[][] memo = new RESULT[text.length() + 1][pattern.length() + 1];
        return dp(text, pattern, memo, 0, 0);
    }

    public boolean dp(String s, String p, RESULT[][] memo, int i, int j){
        boolean ans;
        

        if(j == p.length()){
            return i == s.length();
        }else{
            if(memo[i][j] != null){
                return memo[i][j] == RESULT.TRUE;
            }

            boolean firstMatch =  i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

            // if next char in pattern is *
            // 1. escape such _* in pattern, like text: bc and pattern: a*bc
            // 2. first matched and repeat such _*
            //      2.1 .* - could be text: abcde && pattern .*
            //      2.2 a* - could be text: aaa & pattern: a*  
            //      2.3 when either 2.1 or 2.2 fails, if 1 also fails, then no match
            if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                ans = dp(s, p, memo, i, j + 2) || (firstMatch && dp(s, p, memo, i + 1, j));
            }else{
                ans = firstMatch && dp(s, p, memo, i + 1, j + 1);
            }
        }

        memo[i][j] = ans ? RESULT.TRUE : RESULT.FALSE;

        return ans;
    }
}