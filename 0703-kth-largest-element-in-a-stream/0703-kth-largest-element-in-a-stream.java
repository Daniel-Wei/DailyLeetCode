class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<Integer>((a, b) -> a - b);
        
        for(int num: nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(this.pq.size() < k){
            this.pq.offer(val);
        }else if(this.pq.peek() < val){
            this.pq.poll();
            this.pq.add(val);
        }
        
        return this.pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */