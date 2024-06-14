public class Solution {
    public int MaximumProduct(int[] nums, int k) {
        PriorityQueue<int,int> minHeap = new PriorityQueue<int,int>();
        
        foreach(int num in nums)
             minHeap.Enqueue(num,num);
        
        while(k > 0)
        {
            int min = minHeap.Dequeue();
            minHeap.Enqueue(min + 1, min + 1);
            k--;
        }
        
        long res = 1;
        int modulo = (int)1e9 + 7; // 1e9 == 10^9
        
        while(minHeap.Count > 0)
        {
            res = (res * minHeap.Dequeue()) % modulo;
        }
        
        return (int) res;
    }
}