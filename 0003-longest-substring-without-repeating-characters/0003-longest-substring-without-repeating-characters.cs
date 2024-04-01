public class Solution {
    public int LengthOfLongestSubstring(string s) {
        if(s.Length == 0){
            return 0;
        }
        Dictionary<char, int> dict = new Dictionary<char, int>();
        Dictionary<int, int> next = new Dictionary<int, int>();
        
        int res = 1;
        
        for(int i = 0; i < s.Length; i++){
            char currChar = s[i];
            next.Add(i, s.Length);
            
            if(dict.ContainsKey(currChar)){
                int lastIndex = dict[currChar];
                next[lastIndex] = i;
                dict[currChar] = i;
            }else{
                dict.Add(currChar, i);
            }
        }
        
        for(int i = 0; i < s.Length; i++){
            char currChar = s[i];
            int end = next[i];
            
            for(int j = i; j < end; j ++){
                int innerCurrEnd = next[j];
                
                if(innerCurrEnd < end){
                    end = innerCurrEnd;
                }
            }
            
            res = Math.Max(res, end - i);
            
        }
        
        return res;
    }
}