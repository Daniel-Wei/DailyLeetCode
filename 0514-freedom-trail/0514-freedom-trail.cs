public class Solution {
    public int FindRotateSteps(string ring, string key) {
        int n = ring.Length;
        int m = key.Length;
        int[,]dp = new int[m+1, n];
        
        //对于ith的key的char，以及当前转盘停在jth
        //转至kth的转盘，和ith的key的char相同
        //需要走的步数就是Math.Abs(j-k) = step, 或者反方向 Math.Min(step, n-step)
        //dp[i+1][k]就是key的下一个char 以及转盘停在kth
        //dp[i+1][k] + step就是（下一个char + 转盘停在kth） + 转到（ith char in key + 转盘在jth）
        for(int i = m-1; i >=0; i--){
            for(int j =0; j < n; j++){
                dp[i,j] = int.MaxValue;
                
                for(int k = 0; k < n; k++){
                    if(ring[k] == key[i]){
                        int diff = Math.Abs(j - k);
                        int step = Math.Min(diff, n - diff);
                        dp[i,j] = Math.Min(dp[i, j], dp[i+1, k] + step);
                    }
                }
            }
        }
        
        return dp[0,0] + m;
    }
}