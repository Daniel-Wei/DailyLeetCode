class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
        
        for(int num: nums){
            pq.add(num);
        }
        
        int i = 0;
        
        while(pq.size() > 0){
            nums[i] = pq.poll();
            i++;
        }
        
        return nums;
    }
}