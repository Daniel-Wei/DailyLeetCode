public class Solution {
    public int MinimumOperations(int[] nums) {
        HashSet<int> hs = new HashSet<int>();

        foreach(int num in nums){
            if(num != 0 && !hs.Contains(num)){
                hs.Add(num);
            }
        }
        
        return hs.Count;
    }
}