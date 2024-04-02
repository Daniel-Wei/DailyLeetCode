public class Solution {
    public bool IsIsomorphic(string s, string t) {
        Dictionary<char, char> replacements = new Dictionary<char, char>();
        
        for(int i = 0; i < s.Length; i++){
            char strSChar = s[i];
            char strTChar = t[i];
            
            if(replacements.ContainsKey(strSChar)){
                if(replacements[strSChar] != strTChar){
                    return false;
                }
            }else if(replacements.ContainsValue(strTChar)){
                return false;
            }else{
                replacements.Add(strSChar, strTChar);
            }
        }
        
        return true;
    }
}