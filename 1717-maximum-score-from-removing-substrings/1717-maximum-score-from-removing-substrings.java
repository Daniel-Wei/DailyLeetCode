class Solution {
    public int maximumGain(String s, int x, int y) {
        boolean forAB = x >= y;
        int score = 0;
        StringBuilder sb = new StringBuilder(s);
        
        score = getScore(sb, forAB, score, x, y);
        
        score = getScore(sb, !forAB, score, x, y);
        
        return score;
    }
    
    private int getScore(StringBuilder sb, boolean forAB, int score, int x, int y){
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < sb.length(); i++){
            char c = sb.charAt(i);
            
            if(forAB){
                if(c == 'b' && stack.size() > 0 && stack.peek() == 'a'){
                    stack.pop();
                    score += x;

                    sb.deleteCharAt(i-1);
                    sb.deleteCharAt(i-1);
                   
                    i-=2;
                    
                    continue;
                }
            }else{
                if(c == 'a' && stack.size() > 0 && stack.peek() == 'b'){
                    stack.pop();
                    score += y;
                    
                    sb.deleteCharAt(i-1);
                    sb.deleteCharAt(i-1);
                    i-=2;
                    

                    continue;
                }
            }
            
            stack.push(c);
        }
        
        return score;
    }
}