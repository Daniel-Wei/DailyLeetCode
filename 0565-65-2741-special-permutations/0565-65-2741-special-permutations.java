class Solution {
    public int specialPerm(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][1 << n];
        int mod = (int)1e9 + 7;

        for(int i = 0; i < n; i++){
            Arrays.fill(memo[i], -1);
        }

        int res = 0;

        for(int i = 0; i < n; i++){
            res += dp(1, i, memo, 1 << i, nums, mod);
            res %= mod;
        }

        return res % mod;
    }

    private int dp(int currentIndexToAssign, int prevPickedIndex, int[][] memo, int mask, int[] nums, int mod) 
    {

        if(currentIndexToAssign == memo.length){
            return 1;
        }

        // why add prev picked index ?
        // for one specific mask, 
        // if we have get the total count for all possible prev picked indices (i.e., each picked index)
        // when pick num to be assigned, we could not know what count to reuse, i.e., memo is useless
        // example: we have picked 1, 2, 3
        // when choose number for next, we have 4, 5, 6
        // if we choose 4, what count we could reuse?
        if(memo[prevPickedIndex][mask] != -1){
            return memo[prevPickedIndex][mask];
        }

        int count = 0;

        for(int i = 0; i < memo.length; i++){

            // nums[i] alr used in current mask
            // note: such & results in binary addition
            // 0 & 0 = 1, 1 & 1 = 10, 10 & 10 = 100
            if((mask & (1 << i)) != 0){
                continue;
            }

            if(nums[i] % nums[prevPickedIndex] == 0 || nums[prevPickedIndex] % nums[i] == 0)
            {
                // mask | 1 << i, mark i_th as selected
                count = count % mod + dp(currentIndexToAssign + 1, i, memo, (mask | 1 << i), nums, mod) % mod;
            }
        }
        count %= mod;

        memo[prevPickedIndex][mask] = count;
        return count;

    }
}