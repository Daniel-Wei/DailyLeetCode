public class Solution {
    public string MinRemoveToMakeValid(string s) {
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
        
        Stack<char> newStack = new Stack<char>();
        o = 0;
        c = 0;
        
        while(stack.Any()){
            var curr = stack.Pop();
            
            if(curr == '('){
                o += 1;
            }
            
            if(curr == ')'){
                c += 1;
            }
            
            
            if(curr == '(' && o > c){
                o -= 1;
                continue;
            }else{
                newStack.Push(curr);
            }
        }
        
        while(newStack.Any()){
            res += newStack.Pop();
        }
        
        return res;
        
        
    }
}