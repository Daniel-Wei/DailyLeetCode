class Solution {
    public int minSteps(int n) {
        int res = 0;
        
        while(n != 1){
            for(int i = 2; i <= n; i++){
                while(n % i == 0){
                    n /= i;
                    res += i;
                }
            }
        }
        
        return res;
    }
}