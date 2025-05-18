public class Solution 
{
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) 
    {
        HashMap<Integer, int[]> map = new HashMap<>();
        List<Integer> validRows = generateValidRows(m, map);
        int k = validRows.size();
        int[][] dp = new int[n][k];

        Arrays.fill(dp[0], 1);

        for(int row = 1; row < n; row++){
            for(int currIdx = 0; currIdx < k; currIdx++){
                int curr = validRows.get(currIdx);
                for(int prevIdx = 0; prevIdx < k; prevIdx++){
                    int prev = validRows.get(prevIdx);
                    if(validNeighbourRows(prev, curr, map)){
                        dp[row][currIdx] = (dp[row][currIdx] + dp[row - 1][prevIdx]) % MOD;
                    }
                }
            }
        }

        int res = 0;

        for(int i = 0; i < k; i++){
            res = (res + dp[n - 1][i]) % MOD;
        }

        return res;
    }

    private List<Integer> generateValidRows(int m, HashMap<Integer, int[]> map)
    {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < (int)Math.pow(3, m); i++){
            boolean valid = true;
            int num = i;
            int k = 0;
            int[] digits = new int[m];
            while(num != 0){
                
                digits[k] = num % 3;
                k++;
                num /= 3;
            }


            for(int d = 1; d < m; d++){
                if(digits[d] == digits[d - 1]){
                    valid = false;
                    break;
                }
            }

            if(valid){
                map.put(i, digits);
                res.add(i);
            }
        }

        return res;
    }

    private boolean validNeighbourRows(int prev, int curr, HashMap<Integer, int[]> map){
        int[] prevDigits = map.get(prev);
        int[] currDigits = map.get(curr);

        for(int i = 0; i < prevDigits.length; i++){
            if(prevDigits[i] == currDigits[i]){
                return false;
            }
        }

        return true;

    }
    
}