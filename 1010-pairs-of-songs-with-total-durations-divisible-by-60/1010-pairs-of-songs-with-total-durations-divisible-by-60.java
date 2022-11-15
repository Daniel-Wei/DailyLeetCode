class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[]freqs = new int[60];

        for (int t : time) {
            int reminder = t % 60;
            freqs[reminder] += 1;
        }

        for (int i = 0; i < 31; i++) {
            if(i == 0 || i == 30){
                res += (freqs[i] * (freqs[i] - 1)) / 2;
            }else{
                res += (freqs[i] * freqs[60-i]);
            }
            

        }
        if(res  < 0){
             res += Integer.MAX_VALUE + 1;
        }

        return res ;
    }
}