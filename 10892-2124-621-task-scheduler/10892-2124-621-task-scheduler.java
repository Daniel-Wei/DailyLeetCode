class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int res = 0;

        for(char t : tasks){
            count[t - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

        for(int c : count){
            if(c > 0){
                pq.add(c);
            }
        }

        while(!pq.isEmpty()){
            int size = pq.size();

            List<Integer> addBack = new ArrayList<Integer>();

            for(int i = 0; i < Math.min(n + 1, size); i++){
                res++;
                int f = pq.poll();

                if(f > 1){
                    addBack.add(f - 1);
                }
            }

            if(addBack.size() > 0){
                res += Math.max(n - size + 1, 0);

                for(int f : addBack){
                    pq.add(f);
                }
            }

        }

        return res;
    }
}