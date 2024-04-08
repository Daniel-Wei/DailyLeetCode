public class Solution {
    
    // Tracking exact selections or number of sending to A/B is comsuming and difficuclt
    // Instead, all sending to A first, then sending half to B with the largest minimisation
    public int TwoCitySchedCost(int[][] costs) {
       
        // All send to A
        int res = costs.ToList().Sum(c => c[0]);
        
        List<int> diff = new List<int>();
        
        //Budget diff between sending to A and sending to B
        foreach(int[]cost in costs){
            diff.Add(cost[1] - cost[0]);
        }
        
        diff.Sort();
        
        for(int i = 0; i < costs.Length / 2; i++){
            res += diff[i];
        }
        
        return res;
    }
}