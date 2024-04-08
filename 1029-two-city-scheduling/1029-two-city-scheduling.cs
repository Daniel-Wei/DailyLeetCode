public class Solution {
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