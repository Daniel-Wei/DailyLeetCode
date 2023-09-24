public class Solution {
    public int CoinChange(int[] coins, int amount) {
        
        
        int[]dpMemo = new int[amount + 1];
        
        for(int i = 1; i< dpMemo.Length; i++){
            dpMemo[i] = -1;
        }
        
        Array.ForEach(coins, c => {
            if(c < dpMemo.Length){
                dpMemo[c] = 1;
            }
            
        });
        
        dpMemo[0] = 0;
        
       
        
        for(int i = 1; i <= amount; i++){
            Array.ForEach(coins, c => {
                if(c <= i){
                    if(dpMemo[i - c] != -1){
                        if(dpMemo[i] != -1){
                            dpMemo[i] = Math.Min(dpMemo[i], dpMemo[i - c] + 1);
                        }else{
                            dpMemo[i] = dpMemo[i - c] + 1;
                        }
                    }
                }
                
                
            });
            
//             Array.ForEach(dpMemo, m => {
//                     Console.Write(m);
//                     Console.Write(" ");
//                 });
//                 Console.WriteLine();
            
          
        }
        
        return dpMemo[amount];
        
        
        
    }
}