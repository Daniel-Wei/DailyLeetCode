class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] res = null;

        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }

        for(int[] e: edges){
            int p1 = find(e[0], parent);
            int p2 = find(e[1], parent);

            if(p1 == p2){
                res = e;
            }else{
                parent[p2] = p1;
            }
        }

        return res;
    }

    private int find(int i, int[] parent){
        int p = i;
        while(parent[p] != p){
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }
}