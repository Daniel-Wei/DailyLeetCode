class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][]g = new int[n][n];
        
        for(int[] node : g){
            for(int i = 0; i < n; i++){
                node[i] = -1;
            }
        }
        
        for(int[]e : edges){
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        
        int res = 0;
        int count = n;
        
        for(int i = 0; i < n; i++){
            int currCount = dijkstraAlgo(i, g, n, distanceThreshold);
            
            if(currCount <= count){
                count = currCount;
                res = i;
            }
        }
        
        return res;
    }
    
    private int dijkstraAlgo(int start, int[][]g, int n, int threshold){
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer, Integer>>((a, b) -> a.getValue() - b.getValue());
        
        int[] dist = new int[n];
        
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[start] = 0;
        
        pq.add(new Pair<Integer, Integer>(start, 0));
        
        while(pq.size() > 0){
            Pair<Integer, Integer> curr = pq.poll();
            if(curr.getValue() <= threshold){
                int k = curr.getKey();
                int[]edges = g[k];


                for(int i = 0; i < n; i++){
                    if(edges[i] > 0 && edges[i] + dist[k] < dist[i]){
                        pq.add(new Pair<Integer, Integer> (i, edges[i] + dist[k]));
                        dist[i] = edges[i] + dist[k];
                    }
                }
            }
        }
        
        int count = 0;
        
        for(int d : dist){
            if(d <= threshold){
                count++;
            }
        }
        
        return count;
    }
}