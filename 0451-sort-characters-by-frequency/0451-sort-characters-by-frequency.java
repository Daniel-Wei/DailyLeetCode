class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        
        char[]chars = s.toCharArray();
        
        for(char c : chars){
            m.put(c, m.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        
        for(char k : m.keySet()){
            pq.add(new Pair<Character, Integer>(k, m.get(k)));
        }
                   
        StringBuilder sb = new StringBuilder();
                   
        while(pq.size() > 0){
            Pair<Character, Integer> p = pq.poll();
            int freq = p.getValue();
            char c = p.getKey();
            
            for(int i = 0; i < freq; i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}