public class Solution {
    public int KthFactor(int n, int k) {
        
        int count = 0;
        int res = -1;
        
        for(int i = 1; i < n+1; i++){
            if(n % i == 0){
                count += 1;
            }
            
            if(count == k){
                res = i;
                break;
            }
        }
        
        return res;
        
    }
}