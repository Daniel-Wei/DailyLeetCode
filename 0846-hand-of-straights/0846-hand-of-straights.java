public class Solution {
    public bool IsNStraightHand(int[] hand, int groupSize) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        int min = hand.Min();
        int max = hand.Max();
        
        foreach(int h in hand){
            if(dict.ContainsKey(h)){
                dict[h] += 1;
            }else{
                dict.Add(h, 1);
            }
        }
        
        
        while(min <= max){
            while(dict[min] != 0){
                int k = 0;
                while(k < groupSize){
                    if(dict.ContainsKey(min + k) && dict[min + k] != 0){
                        dict[min + k] -= 1; 
                    }else{
                        return false;
                    }
                    k++;
                }
            }
            
            while((!dict.ContainsKey(min) || dict[min] == 0) && min <= max){
                min++;
            }
        }
        
        return true;
    }
}