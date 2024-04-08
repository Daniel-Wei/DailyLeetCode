public class Solution {
    public int TimeRequiredToBuy(int[] tickets, int k) {
        Queue<int> q = new Queue<int>(tickets);
        int t = tickets[k];
        int counter = 0;
        int curr = 0;
        int res = 0;
        int l = tickets.Length;
        
        while(t != 0){
            curr = q.Dequeue();
            
            if(curr > 0){
                curr -= 1;
                res += 1;
            }
            
            q.Enqueue(curr);
            
            if(counter % l == k){
                t -= 1;
            }
            
            counter += 1;
        }
        
        return res;
    }
}