public class Solution {
    public int PartitionString(string s) {
        HashSet<char> hs = new HashSet<char>();
        int i = 0;
        int res = 1;
        int j = 0;
        
        while(i < s.Length){
            hs= new HashSet<char>();
            hs.Add(s[i]);
            j = i + 1;
            while(j < s.Length){
                if(hs.Contains(s[j])){
                    res += 1;
                    break;
                }else{
                    hs.Add(s[j]);
                    j++; 
                }
                
            }
            i = j;
        }
        
        return res;
    }
}