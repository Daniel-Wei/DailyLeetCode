public class Solution {
    public int FindMaxK(int[] nums) {
        Array.Sort(nums);
        Array.Reverse(nums);
        int l = 0;
        int r = nums.Length - 1;
        int res = -1;
        
        while(nums[l] > 0 && nums[r] < 0){
            if(nums[l] + nums[r] == 0){
                res = nums[l];
                break;
            }
            else if(nums[l] + nums[r] > 0){
                l++;
            }else{
                r--;
            }
        }
        
        return res;
    }
}