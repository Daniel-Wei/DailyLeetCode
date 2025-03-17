// class Solution {
// 	public int splitArray(int[] nums, int k){
// 		int n = nums.length;
// 		int[] prefixSum = new int[n + 1];
// 		int[][] dp = new int[n + 1][k];
//         Arrays.fill(dp[0], -1);

// 		for(int i = 0; i < n; i++){
// 			prefixSum[i + 1] = prefixSum[i] + nums[i];
// 			Arrays.fill(dp[i + 1], -1);
// 		}

// 		return getMinimizedMaxSum(0, k - 1, nums, prefixSum, dp);
// 	}

//     private int getMinimizedMaxSum(int last, int count, int[] nums, int[] prefixSum, int[][] dp)
//     {
//         if(dp[last][count] != -1){
//             return dp[last][count];
//         }
        
//         if(count == 0){
//             return prefixSum[nums.length] - prefixSum[last];
//         }

//         int result = Integer.MAX_VALUE;
//         int currMax = 0;

//         for(int i = last + 1; i < nums.length; i++){
//             currMax += nums[i];

//             currMax = Math.max(currMax, getMinimizedMaxSum(i, count - 1, nums, prefixSum, dp));
//             result = Math.min(currMax, result);
//         }

//         dp[last][count] = result;

//         System.out.println(last);
//         System.out.println(count);
//         System.out.println(result);

//         System.out.println();
        

        
//         return result;
//     }	
	
// }

class Solution {
    public int splitArray(int[] nums, int k) {
        int[][] dp = new int[nums.length+1][k+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(nums,k,0, dp);
    }

    public int solve(int[] nums, int k, int idx, int[][] dp){
        int n = nums.length;
        if( k == 1){
            int sum =0;
            for(int i=idx;i<n;i++){
                sum+=nums[i];
            }
            return sum;
        }
        if(dp[idx][k] != -1) return dp[idx][k];

        int currSum =0, res = Integer.MAX_VALUE, maxSum =0;
        for(int i=idx;i<=n-k;i++){
            currSum += nums[i];
            maxSum = Math.max(currSum, solve(nums,k-1,i+1, dp));
            res = Math.min(res, maxSum);
        }
        dp[idx][k]=res;
        return res;
    }
}
