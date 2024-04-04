public class Solution {
    public bool Makesquare(int[] matchsticks) {
        if(matchsticks.Sum() % 4 != 0){
            return false;
        }
        
        int target = matchsticks.Sum() / 4;
        List<int> lengths = new List<int>();
        
        return Helper(matchsticks, lengths, target, 0);
    }
    
    private bool Helper(int[] matchsticks, List<int> lengths, int target, int index){
        
        //base case
        if(index == matchsticks.Length){
            return lengths.All(l => l == target);
        }
        
        int curr = matchsticks[index];
        
        HashSet<int> distincts = new HashSet<int>();
        
        for(int i = 0; i < lengths.Count; i++){
            int[]arr = lengths.ToArray();
            int l = arr[i];
            
            if(!distincts.Contains(l) && l + curr <= target){
                distincts.Add(l);
                arr[i] += curr;
                
                if(arr[i] <= target && Helper(matchsticks, arr.ToList(), target, index + 1)){
                    return true;
                }
            }
        }
        
        if(lengths.Count < 4){
            lengths.Add(curr);
            if(Helper(matchsticks, lengths, target, index + 1)){
                return true;
            }
        }
        
        return false;
        
    }
}