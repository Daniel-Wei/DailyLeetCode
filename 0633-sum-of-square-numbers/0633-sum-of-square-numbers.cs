public class Solution {
    public bool JudgeSquareSum(int c) {
        long l = 0;
        long r = (long)Math.Sqrt(c);
        
        while(l <= r){
            long curr = l * l + r * r;
            
            if(curr < c){
                l++;
            }else if(curr > c){
                r--;
            }else{
                return true;
            }
        }
        
        return false;
    }
}