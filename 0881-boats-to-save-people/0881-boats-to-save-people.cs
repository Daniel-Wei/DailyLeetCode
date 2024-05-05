public class Solution {
    public int NumRescueBoats(int[] people, int limit) {
        Array.Sort(people);
        int l = 0;
        int r = people.Length - 1;
        int res = 0;
        
        while(l <= r){
            if(people[l] + people[r] <= limit){
                l++;
                r--;
                res++;
            }else{
                r--;
                res++;
            }
        }
        
        
        return res;
    }
}