class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> balls = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        int n = queries.length;
        int[] res = new int[n];
        res[0] = 1;
        balls.put(queries[0][0], queries[0][1]);
        freq.put(queries[0][1], 1);

        for(int i = 1; i < n; i++){
            int ball = queries[i][0];
            int color = queries[i][1];
            int prev = res[i - 1];

            if(balls.containsKey(ball)){
                int prevColor = balls.get(ball);
                int prevFreq = freq.get(prevColor);

                if(prevFreq == 1){
                    prev--;
                }

                freq.put(prevColor, prevFreq - 1);
            }
                
            balls.put(ball, color);

             // same color exists
            if(freq.containsKey(color) && freq.get(color) != 0){
                freq.put(color, freq.get(color) + 1);
            }else{
                freq.put(color, 1);
                prev++;
            }

            res[i] = prev;
        }

        return res;
    }
}