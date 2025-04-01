class Solution {
    public boolean canCross(int[] stones) {
        if(stones.length == 2){
            return stones[1] == 1;
        }

        if(stones[1] != 1){
            return false;
        }
            

        int n = stones.length;
        boolean[][] dp = new boolean[n][n + 1];

        dp[1][1] = true;

        for(int i = 2; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                int jump = stones[i] - stones[j];
                

                // from idx j, the maximum next jump is j + 1
                // 0 - 1, 1- 2, 2 - 3, 3 - 4, 4 - 5, etc
                if(jump <= j + 1) {
                    dp[i][jump] = dp[j][jump - 1] || dp[j][jump] || dp[j][jump + 1];

                    // early break: not neceassary, we have to check all possible last steps to reach a certain stone
                    // test case: [0,1,3,6,10,15,16,21]
                    // 15 -> 16 not available, but 10 -> 16 is available
                    if(i == n - 1 && dp[i][jump]){
                        return true;
                    }
                }else{
                    break;
                }
                
            }
        }

        return false;

    }
}