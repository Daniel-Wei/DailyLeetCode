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
    
    private bool CanSearch(int[]position, int m, int max){
        int last = position[0];
        int count = 1;
        
        foreach(int p in position){
            if(p - last >= max){
                last = p;
                count++;
            }
        }
       
        return count >= m;
    }
}