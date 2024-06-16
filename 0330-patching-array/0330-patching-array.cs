public class Solution {
    public int MinPatches(int[] nums, int n) {
        int i = 0;
        long currMax = 0;
        int res = 0;
        
        while(currMax < n){
            if(i < nums.Length && nums[i] <= currMax + 1){
                currMax += nums[i];
                i++;
            }else{
                currMax += currMax + 1;
                res++;
            }
        }
        
        return res;
    }
}