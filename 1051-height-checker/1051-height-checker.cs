public class Solution {
    public int HeightChecker(int[] heights) {
        int[]copy = new int[heights.Length];
        heights.CopyTo(copy, 0);
        Array.Sort(heights);
        
        int res = 0;
        
        for(int i = 0; i < heights.Length; i++){
            if(heights[i] != copy[i]){
                res++;
            }
        }
        
        return res;
    }
}