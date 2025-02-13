class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        int operations = 0;

        for(int num : nums){
            // why <= instead of <
            // nums: [19,44,61,96,84,79,84,61,97,44]
            // k: 44
            if(num <= k){
                pq.add((long)num);
            }
        }

        while(pq.size() >= 2 && pq.peek() < k){
            long num1 = pq.poll();
            long num2 = pq.poll();

            operations++;

            pq.add(Math.min(num1, num2) * 2 + Math.max(num1, num2));
        }

        return operations;
    }
}