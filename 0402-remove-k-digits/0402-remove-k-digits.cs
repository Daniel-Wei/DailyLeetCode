public class Solution {
    public string RemoveKdigits(string num, int k) {
        Stack<char>s = new Stack<char>();
        s.Push(num[0]);
        
        for(int i = 1; i < num.Length; i++){
            char curr = num[i];
            
            //Push the smaller number to as high digit as possible
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