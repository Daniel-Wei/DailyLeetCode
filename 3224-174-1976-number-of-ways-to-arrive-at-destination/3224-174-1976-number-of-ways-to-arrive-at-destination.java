// class Solution {
//     public int countPaths(int n, int[][] roads) {
//         boolean[] visited = new boolean[n];
//         int[][] neighbours = new int[n][n];
//         long[] minPriceCount = new long[n];
//         minPriceCount[0] = 1;
//         long mod = (int)Math.pow(10, 9) + 7;

//         for(int[] r : roads) {
//             int s = r[0];
//             int d = r[1];
//             int p = r[2];
            
//             neighbours[s][d] = p;
//             neighbours[d][s] = p;
//         }

//         long[] price = new long[n];
//         Arrays.fill(price, Long.MAX_VALUE);
//         price[0] = 0;

//         PriorityQueue<long[]> pq = new PriorityQueue<long[]> (Comparator.comparingLong(a -> a[1]));
//         long[] initial = new long[2];

//         pq.offer(initial);

//         while(!pq.isEmpty()) {
//             long[] currNode = pq.poll();
//             int curr = (int)currNode[0];
//             if(currNode[1] > (long)price[curr]){
//                 continue;
//             }
            
//             int[] currNeighbours = neighbours[curr];
//             visited[curr] = true;
           
//             for(int i = 0; i < n; i++){
//                 if(!visited[i] && currNeighbours[i] != 0) {
//                     long currPrice = (price[curr] % mod + currNeighbours[i] % mod) % mod;
//                     if(currPrice < price[i]) {
//                         price[i] = currPrice;
//                         minPriceCount[i] = minPriceCount[curr];
//                         long[] next = new long[2];
//                         next[0] = i;
//                         next[1] = price[i];
//                         pq.offer(next);
//                     }else if(currPrice == price[i]) {
//                         minPriceCount[i] = (minPriceCount[i] % mod + minPriceCount[curr] % mod) % mod;
//                     }
//                 }
//             }
//         }

//         return (int)(minPriceCount[n - 1] % mod);

//     }
// }

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, 0});

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int) curr[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                int time = neighbor[1];

                if (dist[node] + time < dist[nextNode]) {
                    dist[nextNode] = dist[node] + time;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode], nextNode});
                } else if (dist[node] + time == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}