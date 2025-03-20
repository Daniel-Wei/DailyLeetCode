class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] weight = new int[n];
        int[] res = new int[query.length];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = -1;
        }

        for(int[] e : edges) {
            int p1 = find(e[0], parent);
            int p2 = find(e[1], parent);
            int w = e[2];

            if(weight[p1] == -1){
                weight[p1] = w;
            }else{
                weight[p1] &= w;
            }

            

            if(p1 != p2){
                parent[p2] = p1;

                if(weight[p2] != -1){
                    weight[p1] &= weight[p2]; 
                }
            }
        }
       

        for(int i = 0; i < query.length; i++){
            int[] q = query[i];

            int p1 = find(q[0], parent);
            int p2 = find(q[1], parent);

            if(p1 == p2) {
                res[i] = weight[p1];
            }else{
                res[i] = -1;
            }
        }

        return res;	
    }

    private int find(int i, int[] parent) {
        int p = i;
        while(p != parent[p]) {
            parent[p] = parent[parent[p]]; 
            p = parent[p];
        }

        return p;
    }

}