class Solution {
    public long countGoodIntegers(int n, int k) {
        boolean isOddDigits = n % 2 == 1;
        int firstHalfDigits = n / 2;
        LinkedList<Integer> lst = new LinkedList<Integer>();
        HashSet<String> visited = new HashSet<String>();
        backtrack(lst, 0, isOddDigits, firstHalfDigits, true, k, visited);


        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        long ans = 0;
        for (String s : visited) {
            int[] cnt = new int[10];
            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }
            /* Calculate permutations and combinations */
            long tot = (n - cnt[0]) * factorial[n - 1];
            for (int x : cnt) {
                tot /= factorial[x];
            }
            ans += tot;
        }

        return ans;

    }

    private void backtrack(LinkedList<Integer> lst, int digits, boolean isOddDigits, int halfDigits, boolean initial, int k, HashSet<String> visited){
        
        if(digits < halfDigits){
            if(initial){
                for(int i = 1; i < 10; i++){
                    lst.offer(i);
                    backtrack(lst, digits + 1, isOddDigits, halfDigits, false, k, visited);

                    lst.removeLast();
                }
            }else{
                for(int i = 0; i < 10; i++){
                    lst.offer(i);
                    backtrack(lst, digits + 1, isOddDigits, halfDigits, false, k, visited);
                    lst.removeLast();
                }
            }
        }else if(digits == halfDigits) {
            if(isOddDigits){
                for(int i = 0; i < 10; i++){
                    lst.add(i);
                    backtrack(lst, digits + 1, isOddDigits, halfDigits, false, k, visited);
                    lst.removeLast();
                }
            }else{
                count(lst, k, isOddDigits, visited);
            }
        }else{
            count(lst, k, true, visited);
        }
    }

    private void count(LinkedList<Integer> lst, int k, boolean isOddDigits, HashSet<String> visited){
        int size = lst.size();
        long total = 0;

        if(isOddDigits){
            int leftMost = (size - 1) * 2;
            
            for(int i = 0; i < size - 1; i++){
                int num = lst.get(i);
                total += Math.pow(10, leftMost) * num + Math.pow(10, i) * num;
                leftMost--;
            }

            total += Math.pow(10, leftMost) * lst.get(size - 1);

        }else{
            int leftMost = size * 2 - 1;
            for(int i = 0; i < size; i++){
                int num = lst.get(i);
                total += Math.pow(10, leftMost) * num + Math.pow(10, i) * num;
                leftMost--;
            }
        }

        if(total % k == 0){
            char[] chars = ("" + total).toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);

            visited.add(str);
        }

    }
}