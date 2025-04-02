class Solution {
    public long maximumTripletValue(int[] nums) {
        long res = 0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>((p1, p2) -> (int)(p2 - p1));
        
        if(nums[0] - nums[1] > 0){
            pq.offer((long)(nums[0] - nums[1]));
        }

        

        for(int i = 2; i < nums.length; i++){
            if(!pq.isEmpty()){
                res = Math.max((long)(nums[i] * pq.peek()), res);
            }

            for(int j = 0; j < i; j++){
                if(nums[j] - nums[i] > 0){
                    pq.offer((long)(nums[j] - nums[i]));
                }
            }
        }

        return res;
    }
}