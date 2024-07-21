class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        HashMap<Integer, Integer> rowOrdering = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> colOrdering = new HashMap<Integer, Integer>();

        //Record relationships in row/col conditions
        List<Integer>[] g = new ArrayList[k + 1];
        
        //Record which nodes have been visited, to avoid unnecessary repeated DFS search
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
            
            //Cyclic path has been detected
            if(i == -99){
                return new int[0][0];
            }
        }
        
        //Repeat same process for col conditions
        
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
            
            //Cyclic path has been detected
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
                     // DFS already added nodes in reverse order
                     ordering.put(m, i);
                     i -= 1;
                }
                
            }else{
                //Cyclic path has been detected
                return -99;
            }
        }
        
        return i;
    }
    
    private boolean dfs(int node, boolean[]visited, List<Integer>[] g, List<Integer>reached, HashSet<Integer> tmpVisited){
        
        //Cyclic path has been detected
        if(tmpVisited.contains(node)){
            return false;
        }
        
        if(!visited[node]){
            tmpVisited.add(node);
            visited[node] = true;

            for(int n : g[node]){
                if(!dfs(n, visited, g, reached, tmpVisited)){
                    return false;
                }
            }
            
            reached.add(node);

            // when one node's DFS is done, we removed such node from tmpVisited
            // because in further DFS search, such node could be visited again: [1,2], [1,3], [3,2]
            // tmpVisited purpose: make sure no cyclic paths in current DFS path search
            tmpVisited.remove(node);
        }

        return true;
       
    }
}