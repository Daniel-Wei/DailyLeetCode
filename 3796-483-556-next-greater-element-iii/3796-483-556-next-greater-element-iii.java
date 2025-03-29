class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> digits = new ArrayList<Integer>();

        while(n != 0){
            digits.add(n % 10);
            n /= 10;
        }

        Collections.reverse(digits);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> {
            return p2[1] - p1[1];
        });

        pq.offer(new int[] {digits.size() - 1, digits.get(digits.size() - 1)});
        int[] swap = null;
        int i = digits.size() - 2;

        while(i >= 0) {
            while(!pq.isEmpty() && pq.peek()[1] > digits.get(i)){
                swap = pq.poll();
            }

            if(swap != null){
                break;
            }
            
            pq.offer(new int[] {i, digits.get(i)});
            i--;
        }


        if(swap == null){
            return -1;
        }else{
            int index = swap[0];
            int value = swap[1];
            digits.set(index, digits.get(i));
            digits.set(i, value);
        }

        List<Integer> finalDigits = new ArrayList<Integer>();
        List<Integer> sorted = new ArrayList<Integer>();

        for(int j = 0; j <= i; j++){
            finalDigits.add(digits.get(j));
        }

        for(int j = i + 1; j < digits.size(); j++){
            sorted.add(digits.get(j));
        }
        Collections.sort(sorted);
        finalDigits.addAll(sorted);

        long result = 0;

        for(int j = 0; j < finalDigits.size(); j++){
            result += Math.pow(10, finalDigits.size() - 1 - j) * finalDigits.get(j);

            if(result > Integer.MAX_VALUE){
                return -1;
            }
        }

        return (int)result;
    }
}