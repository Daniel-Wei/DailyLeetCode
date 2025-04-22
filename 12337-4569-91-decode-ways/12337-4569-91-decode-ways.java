class Solution {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if(chars[0] == '0'){
            return 0;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int curr = (int)(chars[i - 1] - '0');
            int prev = (int)(chars[i - 2] - '0');
            int total = prev * 10 + curr;

            if(curr == 0){
                if(prev != 1 && prev != 2){
                    return 0;
                }else{
                    dp[i] = dp[i - 2];
                    continue;
                }
            }

            // as [0..9]
            dp[i] += dp[i - 1];
            
            // as [10..26]
            if(total >= 10 && total <= 26){
                dp[i] += dp[i - 2];
            }

        }

        return dp[n];
    }
}