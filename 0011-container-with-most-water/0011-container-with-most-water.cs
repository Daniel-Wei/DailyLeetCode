public class Solution {
    public int MaxArea(int[] height) {
        int l = 0;
        int r = height.Length - 1;
        int res= 0;
        
        // do not cross each other
        while(l < r){
            int curr = Math.Min(height[l], height[r]) * (r - l);
            
            res = Math.Max(curr, res);
            
            // try to increase the shorter side
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        
        return res;
    }
}