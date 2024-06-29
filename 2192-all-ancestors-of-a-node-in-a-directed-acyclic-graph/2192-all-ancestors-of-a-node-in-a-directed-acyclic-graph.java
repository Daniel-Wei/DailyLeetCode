class Solution {
    private HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[][]g = new int[n][n];
        
        for(int[]edge : edges){
            g[edge[1]][edge[0]] = 1;
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>(n);
        
        for(int i = 0; i < n; i++){
            HashSet<Integer> ancestors = dfs(g, n, i);
            List<Integer> curr = new ArrayList<Integer>(ancestors);
            Collections.sort(curr);
            ans.add(i, curr);
        }
        
        return ans;
    }
    
    private HashSet<Integer> dfs(int[][]g, int n, int node){
        HashSet<Integer>ancestors = new HashSet<Integer>();
        
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        for(int i = 0; i < n; i++){
            if(g[node][i] == 1){
                ancestors.add(i);
                ancestors.addAll(dfs(g, n, i));
            }
        }
       
        map.put(node, ancestors);
        
        return ancestors;
    }
}