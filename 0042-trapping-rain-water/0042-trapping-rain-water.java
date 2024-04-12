class Solution {
    public int trap(int[] height) {
        
        if(height == null || height.length == 0)
            return 0;
        
        int res = 0, leftMax = 0, rightMax = 0, left = 0, right = height.length - 1;
        
        while(left <= right)
        {
            if(height[left] < height[right])
            {              
                if(height[left] < leftMax)
                    res += leftMax - height[left];
                else
                    leftMax = height[left];
                left++;
            }
            else
            { 
                if(height[right] < rightMax)
                    res += rightMax - height[right];
                else
                    rightMax = height[right];
                right--;
            }
        }
        
        return res;
    }
}