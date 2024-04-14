public class Solution {
    public int LargestRectangleArea(int[] heights) {
        Stack<int> s = new Stack<int>();
        int res = 0;
        
        for(int i = 0; i <= heights.Length; i++){
            
            int h = i == heights.Length ? 0 : heights[i];
            
            while(s.Any() && h < heights[s.Peek()]){
                int last = s.Pop();
                int w = s.Any()? i - s.Peek() - 1 : i;
                res = Math.Max(res, heights[last] * w);
            }
            s.Push(i);
        }
        
        return res;
    }
}