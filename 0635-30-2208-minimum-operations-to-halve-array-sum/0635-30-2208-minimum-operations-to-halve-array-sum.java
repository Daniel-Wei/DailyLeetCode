class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
        double sum = 0;
        int operations = 0;

        for(int num : nums){
            sum += (double)num;
            pq.add((double)num);
        }

        double half = sum / 2;

        while(sum > half){
            operations++;
            double halfNum = pq.poll() / 2;
            sum -= halfNum;

            pq.add(halfNum);
        }
        
        return operations;
    }
}