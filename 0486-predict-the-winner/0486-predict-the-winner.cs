public class Solution {
    public bool PredictTheWinner(int[] nums) {
        int n = nums.Length;
    if (n <= 2)
        return true;
    
    int[][] dp = new int[n][];
    for (int i =0 ; i < n; i++)
    {
        dp[i] = new int[n];
    }
    int sum =0;
    for (int i =0 ; i < n;i++)
    {
        dp[i][i] = nums[i];
        sum += nums[i];
    }
    
    for (int i =1 ; i <= n-1;i++)
    {
        for (int j = 0 ; j < n-i;j++)//check this
        {
            int x =0,y = 0;
            if (i != 1)
            {
                x = Math.Min(dp[j+1][i+j-1], dp[j+2][i+j]);
                y = Math.Min(dp[j][i+j-2], dp[j+1][i+j-1]);  
            }

            dp[j][i+j] = Math.Max(nums[j] + x, nums[i+j] + y ); 
        }
    }
    int p1 =  dp[0][n-1];
    int p2 = sum-p1;
    return p1 >= p2 ? true : false;
    }
}