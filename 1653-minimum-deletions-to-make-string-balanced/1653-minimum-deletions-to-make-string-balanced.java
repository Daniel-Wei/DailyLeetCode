class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[]memo = new int[n + 1];
        int b = 0;
        
        for(int i = 0; i < n; i++){
            //memo[i + 1] is for avoiding setting up memo[0]
            if(s.charAt(i) == 'a'){
                //1. Delete all previous b's
                //2. Delete current a
                memo[i + 1] = Math.min(memo[i]+1, b);
            }else{
                b++;
                memo[i + 1] = memo[i];
            }
        }
        
        return memo[n];
    }
}