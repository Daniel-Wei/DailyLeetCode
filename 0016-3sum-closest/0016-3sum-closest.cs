public class Solution {
    public int ThreeSumClosest(int[] nums, int target) {
        Array.Sort(nums);
        
        int l = 0;
        int r = 0;
        int res = 0;
        int curr = 0;
        int prev = 3001;
        int gap = 0;
        int currGap = 0;
        
        
        for(int i = 0; i < nums.Length - 2; i++){
            l = i+1;
            r = nums.Length - 1;
            
            while(l < r){
                curr = nums[i] + nums[l] + nums[r];
                currGap = Math.Abs(curr - target);
                if(prev == 3001 || currGap < gap){
                    prev = curr;
                    gap = currGap;
                }
                
                if(curr > target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        
        return prev;
    }
}