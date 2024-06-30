class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
       Arrays.sort(edges, (a, b)->{
            return b[0]-a[0];
        });
        
        int[] alice = new int[n + 1];
        int[] bob = new int[n + 1];
        
        int res = 0;
        int mergeAlice = 1;
        int mergeBob = 1;
        
        for(int i = 1; i <= n; i++){
            alice[i] = i;
            bob[i] = i;
        }
        
        
        for(int[]e : edges){
            int c = e[0];
            int u = e[1];
            int v = e[2];
            
            if(c == 1){
                if(union(u, v, alice)){
                    mergeAlice += 1;
                }else{
                    res += 1;
                }
            }else if(c == 2){
                if(union(u, v, bob)){
                    mergeBob += 1;
                }else{
                    res += 1;
                }
            }else{
                boolean a = union(u, v, alice);
                boolean b = union(u, v, bob);
                
                if(a){
                    mergeAlice ++;
                }
                
                if(b){
                    mergeBob++;
                }
                
                if(!a && !b){
                    res++;
                }
            }
        }
        
        // Check whether there are N connected nodes for both Alice and Bob
        if(mergeAlice != n || mergeBob != n){
            return -1;
        };
        
        return res;
    }
    
    private boolean union(int u, int v, int[]graph){
        int parentU = find(u, graph);
        int parentV = find(v, graph);
        
        if(parentU != parentV){
            graph[parentU] = parentV;
            return true;
        }else{
            return false;
        }
    }
    
    private int find(int u, int[]graph){
        int parent = graph[u];
        
        if(parent == u){
            return u;
        }
        
        // Backtracking
        int finalRoot = find(parent, graph);
        graph[u] = finalRoot;
        
        return finalRoot;
    }
}