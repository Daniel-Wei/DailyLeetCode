class Solution {
    public int[] constructDistancedSequence(int n) {
        if(n == 1){
            return new int[] {1};
        }
        int[] res = new int[2*n - 1];
        boolean[] used = new boolean[n + 1];
        res[0] = n;
        res[n] = n;
        used[n] = true;

        backtrack(n - 1, res, 1, used);

        return res;
    }

    private boolean backtrack(int k, int[] memo, int empty, boolean[] used){
        
       
        for(int i = k; i > 0; i--){
            if(!used[i] && memo[empty] == 0 && (i == 1 || (empty + i < memo.length && memo[empty + i] == 0))){
                memo[empty] = i;
                if(i > 1){
                    memo[empty + i] = i;
                }
                used[i] = true;

                int next = empty + 1;
                while(next < memo.length && memo[next] != 0){
                    next++;
                }

                if(next == memo.length || backtrack(k, memo, next, used)){
                    return true;
                }

                memo[empty] = 0;
                if(i > 1){
                    memo[empty + i] = 0;
                }
                used[i] = false;

            }
        }

       
        return false;
    }
}