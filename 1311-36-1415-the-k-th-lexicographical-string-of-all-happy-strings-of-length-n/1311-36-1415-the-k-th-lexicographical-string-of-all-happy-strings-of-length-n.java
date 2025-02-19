class Solution {
    int count;
    public String getHappyString(int n, int k) {
        char[] chars = new char[3];
        chars[0] = 'a';
        chars[1] = 'b';
        chars[2] = 'c';

        Stack<Character> s = new Stack<Character>();

        return backtrack(s, k, n, chars);
        
    }


    private String backtrack(Stack<Character>s, int k, int n, char[] chars){
        if(s.size() == n){
            count++;

            if(count == k){
                StringBuilder sb = new StringBuilder();

                while(s.size() > 0){
                    sb.append(s.pop());
                }

                return sb.reverse().toString();
            }
            return "";
        }

        int last = -1;

        if(s.size() > 0){
            last = s.peek() - 'a';
        }


        for(int i = 0; i < 3; i++){
            if(i != last){
                s.push(chars[i]);
                String curr = backtrack(s, k, n, chars);
                if(curr.length() > 0){
                    return curr;
                }
                s.pop();
            }
        }

        return "";
    }
}