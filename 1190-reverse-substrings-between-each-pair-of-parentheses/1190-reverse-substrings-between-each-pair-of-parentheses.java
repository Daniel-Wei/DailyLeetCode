class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                //next index is the start
                stack.push(sb.length());
            }else if(c == ')'){
                //the index of current last char in sb is the end index
                reverseString(sb, stack.pop(), sb.length() - 1);
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    private void reverseString(StringBuilder sb, int start, int end){
        int len = end - start + 1;
        
        for(int i = start; i < start + len / 2; i++){
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(start + end - i));
            sb.setCharAt(start + end - i, temp);
        }
    }
}