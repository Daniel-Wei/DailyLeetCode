class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey()); 
        
        for(int i = 0; i < heights.length; i++){
            pq.add(new Pair<>(heights[i], i));
        }
        
        String[]res = new String[heights.length];
        int i = 0;
        
        while(pq.size() > 0){
            res[i] = names[pq.poll().getValue()];
            i++;
        }
        
        return res;
        
        
    }
}