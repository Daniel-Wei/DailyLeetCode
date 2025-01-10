class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> colorCount = new HashMap<Integer, Integer>();
        int[] q = queries[0];
        int[] res = new int[queries.length];
        HashMap<Integer, Integer> assigned = new HashMap<Integer, Integer>();

        res[0] = 1;
        assigned.put(q[0], q[1]);
        colorCount.put(q[1], 1);

        for(int i = 1; i < queries.length; i++){
            q = queries[i];

            //not colored ball
            if(assigned.get(q[0]) == null){
                assigned.put(q[0], q[1]);

                res[i] = res[i - 1];
                
            }else{
                //prev color
                Integer prevCount = colorCount.get(assigned.get(q[0]));
                colorCount.put(assigned.get(q[0]), prevCount - 1);
                assigned.put(q[0], q[1]);

                //prev color is distinct
                if(prevCount == 1){
                    res[i] = res[i - 1] - 1;
                }else{
                    res[i] = res[i - 1];
                }
            }

            Integer count = colorCount.get(q[1]);

            // new color or no more
            if(count == null || count == 0){
                colorCount.put(q[1], 1);
                res[i]++;
            }else{
                colorCount.put(q[1], count + 1);
            }
        }

        return res;
    }
}