class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] safe = new boolean[n];
        List<Integer> res = new ArrayList<Integer>();

        for(int i = 0; i < n; i++){
            if(isSafeViaDFS(graph, i, visited, safe)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean isSafeViaDFS(int[][] graph, int node, boolean[] visited, boolean[] safe)
    {
        if(visited[node]){
            return safe[node];
        }

        boolean isSafe = true;
        visited[node] = true;

        for(int dest: graph[node]){
            isSafe &= isSafeViaDFS(graph, dest, visited, safe);
        }
        
        safe[node] = isSafe;

        return isSafe;
    }
}