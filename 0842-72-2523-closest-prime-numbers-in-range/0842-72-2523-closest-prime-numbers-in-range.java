class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] sieveOfEratosthenes = new boolean[right + 1];
        sieveOfEratosthenes[0] = true;
        sieveOfEratosthenes[1] = true;

        for(int i = 2; i <= Math.sqrt(right); i++){
            if((long)Math.pow(i, 2) <= right){
                for(int j = i * i; j <= right; j += i){
                    sieveOfEratosthenes[j] = true;
                }
            }
        }

        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        List<Integer> primes = new ArrayList<Integer>();

        for(int i = left; i <= right; i++){
            if(!sieveOfEratosthenes[i]){
                primes.add(i);
            }
        }

        int dist = Integer.MAX_VALUE;

        for(int i = 0; i < primes.size() - 1; i++){
            int curr = primes.get(i + 1) - primes.get(i);
            if(curr < dist){
                dist = curr;
                res[0] = primes.get(i);
                res[1] = primes.get(i + 1);
            }
        }

        return res;
    }
}