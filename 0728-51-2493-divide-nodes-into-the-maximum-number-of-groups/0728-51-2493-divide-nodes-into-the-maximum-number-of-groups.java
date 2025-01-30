class Solution {
    public int magnificentSets(int n, int[][] edges) {
        int[] parent = new int[n + 1];

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            graph.add(new ArrayList<Integer>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            union(e[0], e[1], parent);
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int res = 0;

        for(int i = 1; i <= n; i++){
            int levels = BFS(i, n, graph);
            
            if(levels == 0){
                return -1;
            }

            int r = find(i, parent);

            map.put(r, Math.max(map.getOrDefault(r, 0), levels));
        }

        for(int levels: map.values()){
            res += levels;
        }

        return res;
    }

    private void union(int i, int j, int[] parent){
        int p1 = find(i, parent);
        int p2 = find(j, parent);

        if(p1 != p2){
            parent[p2] = p1;
        }
    }

    private int find(int i, int[] parent){
        int p = i;

        while(p != parent[p]){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    private int BFS(int r, int n,  List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<Integer>();
        int[] level = new int[n + 1];
        level[r] = 1;
        int deepestLevel = 1;

        q.offer(r);

        while(q.size() != 0){
            int size = q.size();

            // for each this level's node
            for(int i = 0; i < size; i++){
                int curr = q.poll();

                // all their neighbours to the queue
                for(int neighbour : graph.get(curr)){
                    if(level[neighbour] == 0){ // not visited
                        level[neighbour] = deepestLevel + 1;
                        q.offer(neighbour);
                    }else if(level[neighbour] == deepestLevel) { // not bipartite 
                        return 0;
                    }
                }
            }

            deepestLevel++;
        }

        return deepestLevel - 1;
    }
}