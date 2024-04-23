public class Solution {
    public IList<int> FindMinHeightTrees(int n, int[][] edges) {
        
        if(edges.Length == 0){
            return new List<int>{0};
        }
        
        Dictionary<int, HashSet<int>> g = new Dictionary<int, HashSet<int>>();
        
        
        foreach(int[]edge in edges){
            int node1 = edge[0];
            int node2 = edge[1];
            
            if(!g.ContainsKey(node1)){
                g.Add(node1, new HashSet<int>{node2});
            }else{
                g[node1].Add(node2);
            }
            
            if(!g.ContainsKey(node2)){
                g.Add(node2, new HashSet<int>{node1});
                
            }else{
                g[node2].Add(node1);
            }
        }
        
        HashSet<int>nodes = g.Keys.ToHashSet();
        Dictionary<int, int> d = g.ToDictionary(p => p.Key, p => p.Value.Count);
        
        while(nodes.Count > 2){
            List<int>neighbours = new List<int>();
            
            foreach(int node in nodes){
                if(d[node] == 1){
                    nodes.Remove(node);
                    int neigh = g[node].Single();
                    neighbours.Add(neigh);
                    g[neigh].Remove(node);
                }
            }
            
            foreach(int neigh in neighbours){
                d[neigh] -= 1;
            }
        }
        
        return nodes.ToList();
    }
}