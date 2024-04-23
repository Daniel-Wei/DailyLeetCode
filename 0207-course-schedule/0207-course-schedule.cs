public class Solution {
    
    Dictionary<int,IList<int>> graph = new Dictionary<int, IList<int>>();
       
    public bool CanFinish(int numCourses, int[][] prerequisites) {
                              
        for(int i=0;i<numCourses;i++)
        {
            graph[i] = new List<int>();
        }             
                    
        var visited = new int[numCourses];
            
        for(int i=0; i < prerequisites.Length; i++)            
        {              
          graph[prerequisites[i][1]].Add(prerequisites[i][0]);           
            
        }

        for(int i=0; i<numCourses; i++)
        {
          if(!DFS(visited,i))
                    return false;
        }
        
        return true;        
    }
    
    private bool DFS(int[] visited, int node)
    {   
        
        visited[node] = 1;        
                               
                  
        for(var i = 0; i < graph[node].Count; i++)
        {                
            if(visited[graph[node][i]] == 1)
            {
                return false;
            }
            
            if(visited[graph[node][i]] == 0)
            {
                if(!DFS(visited, graph[node][i]))
                {
                    return false;
                }    
            }                       
            
        }
        
        visited[node] = 2;
        return true;
    }
}