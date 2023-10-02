public class Solution {
    Dictionary<string, bool> cache = new Dictionary<string, bool>();
    
    public bool CanIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal){
            return true;
        }
        
        int[]used = new int[maxChoosableInteger + 1];
        
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal ){
            return false;
        }
        
        return canIWinWithSituation(desiredTotal, used);
    }
    
   private bool canIWinWithSituation(int curDesiredTotal, int[] chosen) {
        
        if (curDesiredTotal <= 0) { 
            return false;
        }
        
        string chosenSerialization = string.Join("",chosen);
       
        //剪枝
        if (cache.ContainsKey(chosenSerialization)) {
            return cache[chosenSerialization];
        }
        
        for (int i = 1; i < chosen.Length; i++) {
            if (chosen[i] == 1) {
                continue;
            }
            
            chosen[i] = 1;
            //if player two loses == player one would get a force win
            if (!canIWinWithSituation(curDesiredTotal - i, chosen)) {
                cache[chosenSerialization]= true;
                chosen[i] = 0;
                return true;
            }
            chosen[i] = 0;
        }
        cache[chosenSerialization] = false;
        return false;
    }
}