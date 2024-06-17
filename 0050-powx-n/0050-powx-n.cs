public class Solution {
    public double MyPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        
        long p = n;
        bool negative = n < 0;
        
        if(negative){
            p = 0 - p;            
        }
        double half = MyPow(x, (int)(p / 2));
        double res = half * half;
        
        if(p % 2 == 1){
            res *= x;
        }
        
        if(negative){
            res = 1 / res;
        }
        
        if(res == double.PositiveInfinity){
            res = 0;
        }
        
        return res;
    }
}