class Solution {
    public int minOperations(String[] logs) {
        int res = 0;
        
        for(String log: logs){
            int n = log.length();
            char c = log.charAt(n - 2);
            
            // log is "x/"
            if(c != '.'){
                res += 1;
                
            // log is "../"
            }else if(n != 2 && res > 0){
                res -= 1;
            }
        }
        
        return res;
    }
}