public class Solution {
    public string MinRemoveToMakeValid(string s) {
        
        
        // Solution One: TLE
//         Stack<int> stack = new Stack<int>();
//         char[]chars = s.ToCharArray();
//         string res = "";
        
//         // No need to record number of open/closed parenthese
//         // If current char is closed parenthese, try pop the last open parenthese
//         for(int i = 0; i < chars.Length; i++){
//             char ch = chars[i];
//             if(ch == '('){
//                 stack.Push(i);
//             }
            
//             if(ch == ')'){
//                 if(stack.Any()){
//                     stack.Pop();
//                 }else{
//                     chars[i] = '*';
//                 }
//             }
//         }
        
        
//         // Remove remaining open parentheses
//         // 剪枝：不要在反响重复上面的过程
//         while(stack.Any()){
//             chars[stack.Pop()] = '*';
//         }
        
//         for(int i = 0; i < chars.Length; i++){
//             char curr = chars[i];
//             if(curr != '*'){
//                 res += curr;
//             }
//         }
//         return res;
        
        // Solution Two: directly construct res, saved time
        var res = new StringBuilder();
        var openPos = new Stack<int>();
        int i = 0;
        foreach (var c in s)
            switch (c)
            {
                case '(':
                    res.Append(c);
                    openPos.Push(i++);
                    break;
                case ')':
                    if (openPos.Any())
                    {
                        res.Append(c);
                        openPos.Pop();
                        i++;
                    }
                    break;
                default:
                    res.Append(c);
                    i++;
                    break;
            }

        while (openPos.Any())
        {
            var pos = openPos.Pop();
            res.Remove(pos, 1);
        }

        return res.ToString();
    }
}