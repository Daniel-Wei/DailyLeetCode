public class Solution {
    public bool Makesquare(int[] matchsticks) {
        if(matchsticks.Sum() % 4 != 0){
            return false;
        }
        
        int target = matchsticks.Sum() / 4;
        int[] lengths = [0, 0, 0, 0];
        
        return Helper(matchsticks, lengths, target, 0);
    }
    
    private bool Helper(int[] matchsticks, int[]lengths, int target, int index){
        
        //base case
        if(index == matchsticks.Length){
            return lengths.All(l => l == target);
        }
        
        int curr = matchsticks[index];
        
        HashSet<int> distincts = new HashSet<int>();
        
        for(int i = 0; i < lengths.Length; i++){
            int l = lengths[i];
            
            if(!distincts.Contains(l) && l + curr <= target){
                distincts.Add(l);
                lengths[i] += curr;
                
                if(Helper(matchsticks, lengths, target, index + 1)){
                    return true;
                }
                
                lengths[i] -= curr;
                
            }
        }
        
        return false;
        
    }
}