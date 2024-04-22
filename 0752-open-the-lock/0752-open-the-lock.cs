public class Solution {
    public int OpenLock(string[] deadends, string target) {
        string start = "0000";
        Stack<string> s = new Stack<string>();
        HashSet<string> visited = new HashSet<string>();
        visited.Add(start);
        s.Push(start);
        
        HashSet<string> deads = new HashSet<string>(deadends);
        
        if(deads.Contains(target) || deads.Contains(start)){
            return -1;
        }
        
        int level = 0;
        
        while(s.Any()){
            int count = s.Count();
            List<string> currLevel = new List<string>();
            
            // Iterate curr level nodes
            for(int i = 0; i < count; i++){
                string curr = s.Pop();
                
                if(curr == target){
                    return level;
                }
                
                currLevel.Add(curr);

                visited.Add(curr);
            }
            
            // Add next level nodes
            foreach(string curr in currLevel){
                List<string> nexts = GetNext(curr);

                foreach(string next in nexts){
                    if(!visited.Contains(next) && !deads.Contains(next)){
                        visited.Add(next);
                        s.Push(next);
                    }
                }
            }
           
            
            level++;
        }
        
        return -1;
    }
    
    private List<string> GetNext(string curr){
        List<string>next = new List<string>();
            
        for(int i = 0; i < 4; i++){
            char[] charArray1 = curr.ToCharArray();
            charArray1[i] = charArray1[i] == '9' ? '0' : (char)((int) charArray1[i] + 1);
            next.Add(new string(charArray1));

            char[] charArray2 = curr.ToCharArray();
            charArray2[i] = charArray2[i] == '0' ? '9' : (char) ((int)charArray2[i] - 1);
            next.Add(new string(charArray2));
        }
        
        return next;
    }
}