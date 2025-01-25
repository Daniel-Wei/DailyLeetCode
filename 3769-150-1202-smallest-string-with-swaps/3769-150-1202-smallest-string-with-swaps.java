class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parents = new int[n];
        int[] sizes = new int[n];
        HashMap<Integer, PriorityQueue<Character>> uds = new HashMap<Integer, PriorityQueue<Character>>();

        for(int i = 0; i < n; i++){
            parents[i] = i;
            sizes[i] = 1;
        }

        for(List<Integer> p : pairs){
            union(p.get(0), p.get(1), parents, sizes);
        }

        for(int i = 0; i < n; i++){
            PriorityQueue<Character> pq = new PriorityQueue<Character>(); 

            // still can not directly use parents[i]
            // Example: {1, 2}, {0, 3} and {3, 2}
            // which results in parents[1] = 2, parents[0] = 2, parents[3] = 2
            // as two sets {1 -> 2} and {0 -> 3} have same sizes
            // so {3, 2} results in {1 -> 2} + {0 -> 3 -> 2}
            int p = find(i, parents);
            if(uds.containsKey(p)){
                pq = uds.get(p);
            }
           
            pq.offer(s.charAt(i));
            uds.put(p, pq);
        }


        StringBuilder sb = new StringBuilder();

       

        for(int i = 0; i < n; i++){
            // Example: [[17,4],[10,10],[12,19],[14,5],[5,7],[1,2],[2,10],[6,17],[17,18],[16,20],
            //          [14,8],[6,18],[6,11],[2,7],[10,6],[11,7],[8,13],[11,2],[15,14],[14,11],[14,11]]
            int p = find(i, parents);
            if(uds.containsKey(p)){
                sb.append(uds.get(p).poll());
            }else{
                sb.append(s.charAt(p));
            }
        }

        

        return sb.toString();
    }

    private void union(int i, int j, int[] parents, int[] sizes){
        int p1 = find(i, parents);
        int p2 = find(j, parents);

        if(sizes[p1] > sizes[p2]){
            parents[p2] = p1;
            sizes[p1] += sizes[p2];
        }else{
            parents[p1] = p2;
            sizes[p2] += sizes[p1];
        }
    }

    private int find(int i, int[] parents){
        int p = i;
        while(p != parents[p]){
            //path compression
            //{1, 2}, {2, 3} will result in {1, {2, 3}}, no extra levels
            parents[p] = parents[parents[p]];
            p = parents[p];
        }

        return p;
    }
}