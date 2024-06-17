public class Solution {
    public int MySqrt(int x) {
        int l = 0;
        int r = x;
        int mid = x;
        
        while(l <= r){
            mid = (l + r) / 2;
            long curr = (long)mid * mid;
            
            if(curr > x){
                r = mid - 1;
            }else if(curr <= x){
                l = mid + 1;
            }
        }
        
        if((long)mid * mid > x){
            return mid - 1;
        }else{
            return mid;
        }
    }
}