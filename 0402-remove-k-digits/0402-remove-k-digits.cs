public class Solution {
    public string RemoveKdigits(string num, int k) {
        
        if(k == num.Length){
            return "0";
        }
        
        Stack<char>s = new Stack<char>();
        s.Push(num[0]);
        
        for(int i = 1; i < num.Length; i++){
            char curr = num[i];
            
            while(k > 0 && s.Any() && s.Peek() > curr){
                s.Pop();
                k --;
            }
            
            // Avoid leading zero
            // !(!stack.Any() && curr == '0')
            if(s.Any() || curr != '0'){
                 s.Push(curr);
            } 
        }
        
        // In case like (112, 1) should be "11" not "112"
        while(s.Any() && k > 0){
            k--;
            s.Pop();
        }
        
        string res = "0";
        
        if(s.Count > 0){
            res = "";
            while(s.Any()){
                res = s.Pop() + res;
            }
        }
        
        
        
        return res;
    }
}