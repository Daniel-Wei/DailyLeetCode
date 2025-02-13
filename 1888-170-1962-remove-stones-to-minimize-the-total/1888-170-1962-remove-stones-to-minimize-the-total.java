class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());

        int i = 0;

        int sum = 0;

        for(int p : piles){
            pq.add((double)p);
            sum += p;
        }

        while(i < k){
            i++;
            double curr = pq.poll();
            int remove = (int)Math.floor(curr / 2);
            pq.add(curr - remove);
            sum -= remove;

        }

        return sum;
    }
}