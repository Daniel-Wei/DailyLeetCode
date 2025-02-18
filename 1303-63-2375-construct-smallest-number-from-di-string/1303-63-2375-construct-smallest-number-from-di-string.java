class Solution {
    public String smallestNumber(String pattern) {
        boolean[] seen = new boolean[10];
        char[] patterns = pattern.toCharArray();
        Stack<Integer> s = new Stack<Integer>();

        for(int i = 1; i <= 9; i++){
            s.push(i);
            seen[i] = true;

            if(backtrack(seen, patterns, 0, s)){
                break;
            }else{
                s.pop();
                seen[i] = false;
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!s.isEmpty()){
            sb.append(s.pop());
        }


        return sb.reverse().toString();
        
    }

    private boolean backtrack(boolean[] seen, char[] patterns, int index, Stack<Integer> s){
        int last = s.peek();

        if(index == patterns.length){
            return true;
        }

        if(patterns[index] == 'I'){
            for(int i = last + 1; i <= 9; i++){
                if(!seen[i]){
                    s.push(i);

                    seen[i] = true;

                    if(!backtrack(seen, patterns, index + 1, s)){
                        s.pop();
                        seen[i] = false;
                    }else{
                        return true;
                    }
                }
            }
        }else{
            for(int i = last - 1; i >= 1; i--){
                if(!seen[i]){
                    s.push(i);
                    seen[i] = true;

                    if(!backtrack(seen, patterns, index + 1, s)){
                        s.pop();
                        seen[i] = false;
                    }else{
                        return true;
                    }
                }
            }
        }

        return false;
    }
}