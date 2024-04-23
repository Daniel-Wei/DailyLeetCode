public class Solution {
    public bool CanFinish(int numCourses, int[][] prerequisites) {
        
        //With comfirmed number of nodes
        //Better use Array rather than Dict/HashSet
        List<int>[] g = new List<int>[numCourses];
        bool[] visited = new bool[numCourses];
        bool[] tmpVisited = new bool[numCourses];
        
        for(int i = 0; i < numCourses; ++i){
            g[i] = new List<int>();
        }
        
        for(int i = 0; i < prerequisites.GetLength(0); ++i){
            g[prerequisites[i][1]].Add(prerequisites[i][0]);
        }
        
        for(int i = 0; i < numCourses; ++i){
            if(!Dfs(g, visited, tmpVisited, i))
                return false;
        }
        
        return true;
    }
    
    private bool Dfs(List<int>[] graph, bool[] visited, bool[] tmpVisited, int node){
        if(tmpVisited[node])
            return false;
        if(visited[node])
            return true;
        
        tmpVisited[node] = true;
        
        foreach(int n in graph[node]){
            if(!Dfs(graph, visited, tmpVisited, n))
                return false;
        }
        
        tmpVisited[node] = false;
        visited[node] = true;
        return true;
    }
}