public class Solution{
    public string RemoveDuplicates(string s, int k)
    {
        //no need to track specific index of each char
        //just record latest count of each char
        Stack<(char ch, int count)> stack = new Stack<(char, int)>();
        StringBuilder sb = new StringBuilder();
        
        foreach(char c in s){
            if(stack.Any() && stack.Peek().ch == c){
                var temp = stack.Pop();
                temp.count += 1;
                
                if(temp.count != k){
                    stack.Push(temp);
                }
            }else{
                stack.Push((c, 1));
            }
        }
        
        
        while (stack.Any())
        {
            var top = stack.Pop();
            for (int i = 0; i < top.count; i++)
            {
                sb.Append(top.ch);
            }
        }
        
        char[]chars = sb.ToString().ToCharArray();
        
        //FILO
        Array.Reverse(chars);
        return new string(chars);
    }
}