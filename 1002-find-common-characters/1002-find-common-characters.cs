public class Solution {
    public IList<string> CommonChars(string[] words) {
        IList<string> res = new List<string>();
        
        foreach(char c in words[0]){
            bool all = true;
            for(int i = 1; i < words.Length; i++){
                if(!words[i].Contains(c)){
                    all = false;
                    break;
                }
            }
            
            if(all){
                res.Add(c.ToString());
                for(int i = 1; i < words.Length; i++){
                    words[i] = words[i].Remove(words[i].IndexOf(c)) + words[i].Substring(words[i].IndexOf(c) + 1);
                }
            }
        }
        
        
        
        return res;
    }
}