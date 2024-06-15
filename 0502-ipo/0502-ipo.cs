public class Solution {
    public int FindMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[], int> pqCapital = new PriorityQueue<int[], int>();
        PriorityQueue<int, int> pqProfit = new PriorityQueue<int, int>();
        
        
        for(int i = 0; i < profits.Length; i++){
            // order by capital asc
            pqCapital.Enqueue(new int[]{capital[i], profits[i]}, capital[i]);
        }
        
        while(k > 0){
            while(pqCapital.Count > 0 && pqCapital.Peek()[0] <= w){
                int profit = pqCapital.Dequeue()[1];
                 
                // order by profit desc
                // and it would not lose any data
                // example: 3, 0, [1, 2, 3], [0, 1, 1]
                // if just keep dequeue() pgCapital, profit 2- capital 1 will be lost
                pqProfit.Enqueue(profit, -profit);
            }
            
            if(pqProfit.Count != 0){
                w += pqProfit.Dequeue();
            }else{
                break;
            }
            
            k--;
        }
        
        return w;
    }
}