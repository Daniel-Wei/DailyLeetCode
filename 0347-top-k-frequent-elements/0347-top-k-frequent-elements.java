class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> b.getValue() - a.getValue());
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for(int n : nums){
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        
        for(int n : m.keySet()){
            pq.add(new Pair<Integer, Integer>(n, m.get(n)));
        }
        
        int i = 0;
        
        int[]res = new int[k];
        
        while(i < k){
            res[i] = pq.poll().getKey();
            i++;
        }
        
        return res;
    }
}