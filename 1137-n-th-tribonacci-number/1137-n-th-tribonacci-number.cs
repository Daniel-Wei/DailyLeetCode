public class Solution {
    public int Tribonacci(int n) {
        if(n == 0 || n == 1){
            return n;
        }
        
        if(n == 2){
            return 1;
        }
        
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        nums[2] = 1;
        
        for(int i = 3; i < n + 1; i++){
            nums[i] = nums[i-1] + nums[i-2] + nums[i-3];
        }
        
        return nums[n];
    }
}