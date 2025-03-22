class Solution {
    public int countCompleteComponents (int n, int[][] edges) 
    {
        int[] parent = new int[n];
        int[] neighbours = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int [] e: edges) {
            int n1 = e[0];
            int n2 = e[1];

            int p1 = find(n1, parent);
            int p2 = find(n2, parent);

            if(p1 != p2) {
                parent[p2] = p1;
            }

            neighbours[n1] ++;
            neighbours[n2] ++;

        }

        int result = 0;
        int[] groupCounts= new int[n];
        boolean[] group = new boolean[n];

        for(int i = 0; i < n; i++) {
            int p = find(i, parent);
            groupCounts[p]++;

            if(!group[p]) {
                group[p] = true;
                result ++;
            } 
        }

            
        for(int i = 0; i < n; i++) {
            int p = parent[i];
            
            if(group[p]) {
                int groupCount = groupCounts[p];
                
                if(groupCount != neighbours[i] + 1) {
                    group[p] = false;
                    result --;
                }

            }
        }

        return result;
    }

    private int find(int i, int[] parent) {
        int p = i;

        while(p != parent[p]) {
            parent[p]  = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

}