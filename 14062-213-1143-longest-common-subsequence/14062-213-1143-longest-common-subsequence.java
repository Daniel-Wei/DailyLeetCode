class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        int n1 = chars1.length;
        int n2 = chars2.length;

        int[][] dp = new int[n1][n2];

        if(chars1[0] == chars2[0]){
            dp[0][0] = 1;
        }

        for(int i = 1; i < n1; i++){

            if(chars1[i] == chars2[0] || dp[i - 1][0] == 1){
                dp[i][0] = 1;
            }
        }


        for(int j = 1; j < n2; j++){

            if(chars2[j] == chars1[0] || dp[0][j - 1] == 1){
                dp[0][j] = 1;
            }
        }

        for(int i = 1; i < n1; i++){

            for(int j = 1; j < n2; j++){
                if(chars1[i] == chars2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n1 - 1][n2 - 1];
    }
}