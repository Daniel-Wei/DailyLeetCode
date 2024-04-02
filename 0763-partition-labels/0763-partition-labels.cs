public class Solution {
    public IList<int> PartitionLabels(string s) {
        Dictionary<char, int> lastIndex = new Dictionary<char, int>();
        IList<int> res = new List<int>();
        
        for(int i = 0; i < s.Length; i++){
            char curr = s[i];
            
            if(lastIndex.ContainsKey(curr)){
                lastIndex[curr] = i;
            }else{
                lastIndex.Add(curr, i);
            }
        }
        
        for(int i = 0; i < s.Length; i++){
            char curr = s[i];
            
            int end = lastIndex[curr];
            
            HashSet<char> distinctChars = new HashSet<char>();
            
            for(int j = i + 1; j < end; j++){
                char innerCurr = s[j];
                
                if(distinctChars.Contains(innerCurr)){
                    continue;
                }else{
                    end = Math.Max(lastIndex[innerCurr], end);
                    
                    if(end == s.Length - 1){
                        break;
                    }
                }
            }
            
            res.Add(end - i + 1);
            i = end;
        }
        
        return res;
        
        
    }
}