class Solution {
    public int kthFactor(int n, int k) {
        int i = 1;

        while(k != 0 && i <= n){
            if(n % i == 0){
                k--;
            }

            i++;
        }

        return k > 0 ? -1 : i - 1;
    }
}