class Solution {
    public int Trap(int[] height) {
        int l = 0;
        int r = 1;
        int res = 0;
        
        while(r < height.Length){
            if(height[r] <= height[l]){
                r ++;
            }else{
                for(int i = l + 1; i < r; i++){
                    res += height[l] - height[i];
                }
                
                l = r;
                r++;
            }
        }
        
        
        
        l = height.Length - 2;
        r = height.Length - 1;
        
        while(l >= 0){
            if(height[l] < height[r]){
                l--;
            }else{
                for(int i = l + 1; i < r; i++){
                    res += height[r] - height[i];
                }
                
                r = l; 
                l--;
            }
        }
        
        return res;
    }
}