class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        int k = numBottles;
        int e = numExchange;
        
        while(k >= e){
            k-=e;
            e++;
            k++;
            res++;
        }
        
        return res;
        
    }
}