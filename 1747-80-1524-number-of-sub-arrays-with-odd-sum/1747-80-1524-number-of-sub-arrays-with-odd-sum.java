class Solution {
    public int numOfSubarrays(int[] arr) {
        int res = 0;
        int odd = 0;
        int even = 0;

        for(int num : arr){
            if(num % 2 == 0){
                even++;
            }else{
                int tmpOdd = odd;
                int tmpEven = even;
                even = tmpOdd;
                odd = tmpEven;
                odd++;
                
            }

            res += odd;
            res %= 1000000007;
        }

        return res % 1000000007;
    }
}