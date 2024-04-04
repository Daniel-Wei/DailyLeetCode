public class Solution {
    public int MaxDepth(string s) {
        int maxDepth = 0;
        int currDepth = 0;
        
        foreach(char c in s){
            if(c == '('){
                currDepth += 1;
                maxDepth = Math.Max(maxDepth, currDepth);
            }else if(c == ')'){
                currDepth -= 1;
            }
        }
        
        return maxDepth;
    }
}