public class Solution {
    public string ReversePrefix(string word, char ch) {
        int index = -1;
        
        for(int i = 0; i < word.Length; i++){
            if(word[i] == ch){
                index = i;
                break;
            }
        }
        
        if(index == -1){
            return word;
        }
        
        string sub1 = word.Substring(0, index + 1);
        string sub2 = word.Substring(index+1);
        
        char[] chars = sub1.ToCharArray();
        Array.Reverse(chars);
        sub1 = new string(chars);
        
        return sub1 + sub2;
    }
}