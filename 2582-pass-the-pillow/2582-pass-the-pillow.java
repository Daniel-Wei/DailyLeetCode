class Solution {
    public int passThePillow(int n, int time) {
        int k = time / (n - 1);
        int m = time % (n - 1);
        
        if(k % 2 == 0){
            return 1 + m;
        }else{
            return n - m;
        }
            
    }
}