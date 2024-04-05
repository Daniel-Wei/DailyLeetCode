public class Solution {
    public string MakeGood(string s) {
        Stack<char> stack = new Stack<char>();
        
        for(int i = 0; i < s.Length; i++){
            char curr = s[i];
            
            if(stack.Count == 0){
                stack.Push(curr);
            }else{
                char last = stack.Peek();
                if(Math.Abs((int)last - (int)curr) == 32){
                    stack.Pop();
                }else{
                    stack.Push(curr);
                }
            }
        }
        
        char[] chars = stack.ToArray();
        Array.Reverse(chars);
        
        return new string(chars);
    }
}