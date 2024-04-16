public class Solution {
    public int MaximumScore(int[] nums, int k) {
        Stack<int> s = new Stack<int>();
        int res = 0, w = 0, last = 0, start = 0;
        
        for(int i = 0; i <= nums.Length; i++){
            int h = i == nums.Length? 0 : nums[i];
            
            while(s.Any() && h < nums[s.Peek()]){
                last = s.Pop();
                
                start = s.Any()? s.Peek() + 1: 0;
                
                if(start <= k && k < i){
                    w = s.Any()? i - s.Peek() - 1: i;
                    
                    // Console.WriteLine(i);
                    // Console.WriteLine(w);
                    // Console.WriteLine(last);
                    // Console.WriteLine();
                    
                    res = Math.Max(res, nums[last] * w);
                }
                
            }
            s.Push(i);
        }
        
        return res;
    }
}