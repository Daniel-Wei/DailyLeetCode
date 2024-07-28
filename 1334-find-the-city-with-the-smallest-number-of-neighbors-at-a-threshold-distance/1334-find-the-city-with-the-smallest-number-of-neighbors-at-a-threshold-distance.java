class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[]graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<int[]>();
        }
        
        for(int[]e : edges){
            int u = e[0];
            int v = e[1];
            int d = e[2];
            
            graph[u].add(new int[]{v, d});
            graph[v].add(new int[]{u, d});
            
        }
        
        int res = 0;
        int count = n;
        
        for(int i = 0; i < n; i++){
            int currCount = dijkstraAlgo(i, graph, n, distanceThreshold);
            
            if(currCount <= count){
                count = currCount;
                res = i;
            }
        }
        
        return res;
    }
    
    private int dijkstraAlgo(int start, List<int[]>[]g, int n, int threshold){
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        
        int[] dist = new int[n];
        
        for(int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[start] = 0;
        
        pq.add(new int[]{start, 0});
        
        while(pq.size() > 0){
            int[] curr = pq.poll();
            if(curr[1] <= threshold){
                int k = curr[0];
                List<int[]> edges = g[k];


                for(int[]e : edges){
                    int v = e[0];
                    int d = e[1];
                    if(d + dist[k] < dist[v]){
                        pq.add(new int[] {v, d + dist[k]});
                        dist[v] = d + dist[k];
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