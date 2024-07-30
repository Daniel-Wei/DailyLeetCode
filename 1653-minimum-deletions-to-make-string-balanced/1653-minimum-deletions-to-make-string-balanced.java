class Solution {
    public int minimumDeletions(String s) {
        char[]chars = s.toCharArray();
        int[]memo = new int[chars.length + 1];
        int b = 0;
        
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 'a'){
                memo[i + 1] = Math.min(memo[i]+1, b);
            }else{
                b++;
                memo[i + 1] = memo[i];
            }
        }
        
        
        
        return memo[chars.length];
    }
}