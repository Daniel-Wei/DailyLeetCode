public class Solution {
    public int MaxDistance(int[] position, int m) {
        Array.Sort(position);
       
        // low and high are possible forces
        int low = 1;
        int high = position[position.Length - 1] - position[0];
        int res = 0;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(CanSearch(position, m, mid)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        return res;
    }
    
    private bool CanSearch(int[]position, int numOfBalls, int force){
        int last = position[0];
        
        // for example: m = 3
        // there should be two indexes in the position 
        // that position[i-1] - position[0] >= force && position[i-2] - position[0] >= force
        int count = 1;
        
        foreach(int p in position){
            if(p - last >= force){
                last = p;
                count++;
            }
        }
       
        return count >= numOfBalls;
    }
}