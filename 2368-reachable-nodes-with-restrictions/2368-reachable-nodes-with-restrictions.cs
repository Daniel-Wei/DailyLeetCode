public class Solution {
    public int ReachableNodes(int n, int[][] edges, int[] restricted) {
        Dictionary<int, List<int>> graph = new Dictionary<int, List<int>>();
        HashSet<int> deadends = new HashSet<int>(restricted);
        HashSet<int> visited = new HashSet<int>();
        
        if(deadends.Contains(0)){
            return 0;
        }
        
        foreach(int[]edge in edges){
            int node1 = edge[0];
            int node2 = edge[1];
            
            if(!deadends.Contains(node1) && !deadends.Contains(node2)){
                
                if(!graph.ContainsKey(node1)){
                    graph.Add(node1, new List<int>{node2});
                }else{
                    graph[node1].Add(node2);
                }
                
                if(!graph.ContainsKey(node2)){
                    graph.Add(node2, new List<int>{node1});
                }else{
                    graph[node2].Add(node1);
                }
            }
        }
        
        Stack<int>s = new Stack<int>();
        
        s.Push(0);
        int res = 0;
        
        while(s.Any()){
            List<int> next = new List<int>();
            for(int i = 0; i < s.Count; i++){
                int curr = s.Pop();
                visited.Add(curr);
                res++;
                
                if(graph.ContainsKey(curr)){
                    next.AddRange(graph[curr]);
                }
            }
            
            foreach(int node in next){
                if(!visited.Contains(node)){
                    s.Push(node);
                }
            }
        }
        
        return res;
    }
}