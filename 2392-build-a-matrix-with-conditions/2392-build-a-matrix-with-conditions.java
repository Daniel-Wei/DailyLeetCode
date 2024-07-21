class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        HashMap<Integer, Integer> rowOrdering = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> colOrdering = new HashMap<Integer, Integer>();

        List<Integer>[] g = new ArrayList[k + 1];
        boolean[]visited = new boolean[k + 1];
        
        for(int m = 1; m < k + 1; m++){
            g[m] = new ArrayList<Integer>();
        }
        
        for(int[] r : rowConditions){
            g[r[0]].add(r[1]);
        }
        
        int i = k - 1;
        
        for(int j = 1; j <= k; j++){
            i = topologicalSort(visited, j, rowOrdering, k, g, i);
            if(i == -99){
                return new int[0][0];
            }
        }
        
        i = k - 1;
        
        visited = new boolean[k + 1];
        
        for(int m = 1; m < k + 1; m++){
            g[m] = new ArrayList<Integer>();
        }
        
        for(int[] r : colConditions){
            g[r[0]].add(r[1]);
        }
        
        for(int j = 1; j <= k; j++){
            i = topologicalSort(visited, j, colOrdering, k, g, i);
            if(i == -99){
                return new int[0][0];
            }
        }
        
        
        int[][]matrix = new int[k][k];
        
        for(int j = 1; j <= k; j++){
            matrix[rowOrdering.get(j)][colOrdering.get(j)] = j;
        }
        
        return matrix;
    }
    
    private int topologicalSort(boolean[]visited, int node, HashMap<Integer, Integer> ordering, int k, List<Integer>[] g, int i){
        if(visited[node] == false){
            List<Integer> reached = new ArrayList<Integer>();
            HashSet<Integer> tmpVisited = new HashSet<Integer>();
            
            if(dfs(node, visited, g, reached, tmpVisited)){
                for(int m: reached){
                     ordering.put(m, i);
                     i -= 1;
                }
                
            }else{
                return -99;
            }
        }
        
        return i;
    }
    
    private boolean dfs(int node, boolean[]visited, List<Integer>[] g, List<Integer>reached, HashSet<Integer> tmpVisited){
        if(tmpVisited.contains(node)){
            return false;
        }
        
        if(visited[node] == false){
            tmpVisited.add(node);
            visited[node] = true;

            for(int n : g[node]){
                if(!dfs(n, visited, g, reached, tmpVisited)){
                    return false;
                }
            }

            tmpVisited.remove(node);
            reached.add(node);
        }
       
        return true;
       
    }
}