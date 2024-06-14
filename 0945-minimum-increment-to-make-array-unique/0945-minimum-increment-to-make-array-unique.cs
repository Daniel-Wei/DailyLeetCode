public class Solution {
    public int MinIncrementForUnique(int[] nums) {
        Array.Sort(nums);
        int res = 0;
        int prev = nums[0];
        
        for(int i = 1; i < nums.Length; i++){
            int curr = nums[i];
            
            if(curr <= prev){
                res += prev - curr + 1;
                prev++;
            }else{
                prev = curr;
            }
            
        }
        
        return res;
    }
}