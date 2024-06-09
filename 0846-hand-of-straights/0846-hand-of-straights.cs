public class Solution {
    public bool IsNStraightHand(int[] hand, int groupSize) {
         
        Dictionary<int, int> dict = new Dictionary<int, int>();
        
        foreach(int num in hand){
            if(!dict.ContainsKey(num))
                dict.Add(num, 0);
            dict[num]++;
        }

        while(dict.Count >= groupSize){
            int min = dict.Keys.Min();
            for(int i = 0; i < groupSize; i++){
                if(dict.ContainsKey(min)){
                    dict[min]--;
                    
                    if(dict[min] == 0)
                        dict.Remove(min);
                    
                    min++;
                }
                else{
                    return false;
                }
            }
        }
        if(dict.Count > 0)
            return false;
        return true;
    }
}