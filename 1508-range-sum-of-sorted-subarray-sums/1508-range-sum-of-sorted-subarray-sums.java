class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int s = 0;
        long res = 0;
        int sum = 0;
        int e = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> a - b);
        
        while(s < n){
            sum = nums[s];
            e = s;
            pq.add(sum);
            
            while(e < n - 1){
                e++;
                sum += nums[e];
                pq.add(sum);
            }

            s++;
        }
        
        int i = 1;
        int mod = (int)1e9 + 7;
        
        while(pq.size() > 0){
            
            long curr = pq.poll() % mod;
            
            if(i >= left && i <= right){
                res = (res + curr) % mod;
            }
            
            i++;
        }
        
        return (int)res;
        
    }
}