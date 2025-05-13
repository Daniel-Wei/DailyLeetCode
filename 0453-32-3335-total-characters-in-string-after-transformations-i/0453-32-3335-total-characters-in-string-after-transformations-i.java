class Solution {
    public static final int MOD = 1000000007;

    public int lengthAfterTransformations(String s, int t) {
        int[] count = new int[26];

        // why?
        for(int c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        while(t > 0){
            int [] next = new int[26];
            for(int i = 0; i < 25; i++){
                next[i + 1] = count[i];
            }

            next[0] = count[25];
            next[1] = (next[1] + count[25]) % MOD;
            t--;
            count = next;
        }

        int res = 0;

        for(int c : count){
            res = (res + c) % MOD;
        }


        return res;
    }
}