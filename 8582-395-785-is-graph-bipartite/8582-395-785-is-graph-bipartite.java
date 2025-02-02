class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] memo = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < n; i++){
            if(memo[i] == 0){
                q.offer(i);

                // bfs will check all nodes in the same connected component
                // so we could assign it to any group
                memo[i] = -1;
                if(!bfsBipartiteCheck(q, memo, graph)){
                    return false;
                }
            }
        }
        

        return true;
    }

    private boolean bfsBipartiteCheck(Queue<Integer> q, int[] memo, int[][] graph){
        while(!q.isEmpty()){
            int curr = q.poll();
            int g = memo[curr];

            for(int node : graph[curr]){
                if(memo[node] == 0){
                    memo[node] = 0 - g;
                    q.offer(node);
                }else if(memo[node] + g != 0){
                    return false;
                }
            }
        }

        return true;
    }
}