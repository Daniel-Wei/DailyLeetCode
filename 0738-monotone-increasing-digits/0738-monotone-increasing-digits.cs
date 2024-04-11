public class Solution {
    public int MonotoneIncreasingDigits(int n) {
        
        List<int> l = new List<int>();
        
        while(n > 0){
            l.Add(n % 10);
            n /= 10;
        }
        
        int stop = -1;
    
        for(int i = 0; i < l.Count - 1; i++){
            if(l[i] < l[i+1]){
                l[i] = 9;
                l[i+1] -= 1;
                stop = i;
            }
        }
        
        for(int i = 0; i <= stop; i++){
            l[i] = 9;
        }
        
        l.Reverse();
        
        
        int total = 0;
        foreach (int entry in l)
        {
            total = 10 * total + entry;
        }
        

        
        return total;
    }
}