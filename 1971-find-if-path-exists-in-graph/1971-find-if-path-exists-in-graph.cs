public class Solution {
    public bool ValidPath(int n, int[][] edges, int source, int destination) {
        HashSet<int>visited = new HashSet<int>();
        Dictionary<int, List<int>> dict = new Dictionary<int, List<int>>();
        Stack<int>s = new Stack<int>();
        bool res = false;
        
        foreach(int[]edge in edges){
            if(!dict.ContainsKey(edge[0])){
                dict.Add(edge[0], new List<int>{edge[1]});
            }else{
                dict[edge[0]].Add(edge[1]);
            }
            
            if(!dict.ContainsKey(edge[1])){
                dict.Add(edge[1], new List<int>{edge[0]});
            }else{
                dict[edge[1]].Add(edge[0]);
            }
        }
        
        s.Push(source);
        
        while(s.Any()){
            int curr = s.Pop();
            visited.Add(curr);
            
            if(curr == destination){
                res = true;
                break;
            }
            
            if(dict.ContainsKey(curr)){
                foreach(int node in dict[curr]){
                    if(!visited.Contains(node)){
                        s.Push(node);
                    }
                }
            }
        }
        
        return res;
        
        // return Helper(dict, visited, source, destination);
    }
    
    // Stack Overflow
//     private bool Helper(Dictionary<int, List<int>>dict, HashSet<int>visited, int curr, int destination){
//         if(curr == destination){
//             return true;
//         }
        
//         bool res = false;
        
//         if(dict.ContainsKey(curr)){
//             visited.Add(curr);
//             List<int>next = dict[curr];
            
//             foreach(int node in next){
//                 if(!visited.Contains(node)){
//                     res = res || Helper(dict, visited, node, destination);
//                     if(res){
//                         break;
//                     }
//                 }
//             }
            
//         }

//         return res;
//     }
}