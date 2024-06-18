public class Solution {
    public int MaxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        List<Task> tasks = new List<Task>();
        
        for(int i = 0; i < profit.Length; i++){
            tasks.Add(new Task(){
                Difficulty = difficulty[i],
                Profit = profit[i]
            });
        }
        
        tasks = tasks.OrderBy(t => t.Difficulty).ToList();
        int res = 0;
        
        foreach(int w in worker){
            res += GetMaxProfit(tasks, w);
        }
        
        return res;
    }
    
    private int GetMaxProfit(List<Task> tasks, int worker){
        
        if(worker < tasks[0].Difficulty){
            return 0;
        }
        
        int i = 0;
        int maxProfit = -1;
        
        while (i < tasks.Count && tasks[i].Difficulty <= worker){
            maxProfit = Math.Max(maxProfit, tasks[i].Profit);
            i++;
        }
        
        return maxProfit;
    }
    
    private class Task{
        public int Difficulty {get; set;}
        public int Profit {get; set;}
    }
}