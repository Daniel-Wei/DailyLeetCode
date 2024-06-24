class Solution {
    public int minKBitFlips(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = nums.length;
        int res = 0;
        
        for(int i = 0; i < n; i++){
                
            // keep the sliding window size as k
            while(deque.size() > 0 && i > deque.peekFirst() + k - 1){
                deque.pollFirst();
            }
            
            // greedily flip bits whenever there is a 0
            if((deque.size() + nums[i]) % 2 == 0){
                if(i + k > n){
                    return -1;
                }

                res++;
                deque.add(i);
            }
        }
        
        return res;
    }
}