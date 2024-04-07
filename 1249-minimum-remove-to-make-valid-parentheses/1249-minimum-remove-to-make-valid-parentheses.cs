public class Solution {
    public string MinRemoveToMakeValid(string s) {
        // Solution One: Almost TLE
        Stack<char> stack = new Stack<char>();
        int o = 0;
        int c = 0;
        string res = "";
        
        foreach(char ch in s){
            if(ch == '('){
                o += 1;
            }
            
            if(ch == ')'){
                c += 1;
            }
            
            
            if(ch == ')' && c > o){
                c -= 1;
                continue;
            }else{
                stack.Push(ch);
            }
        }
        
        
        // Remove remaining open parentheses
        // 剪枝：不要在反响重复上面的过程
        while(stack.Any()){
            var curr = stack.Peek();
            stack.Pop();
            if(curr == '(' && o > c){
                o --;
            }else{
                res += curr;
            }
           
        }
        
        char[]chars = res.ToCharArray();

        //FILO
        Array.Reverse(chars);
        return new string(chars);
    }
}