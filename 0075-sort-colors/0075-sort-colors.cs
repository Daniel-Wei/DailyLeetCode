public class Solution {
    public void SortColors(int[] nums) {
        int[]countings = new int[3];
        
        foreach(int num in nums){
            countings[num] += 1;
        }
        
        for(int i = 2; i > 0; i--){
            countings[i] = countings[i-1];
        }
        countings[0] = 0;
        
        for(int i = 1; i < 3; i++){
            countings[i] += countings[i-1];
        }
        
        for(int i = 0; i < 3; i++){
            int start = countings[i];
            
            int end = i == 2? nums.Length : countings[i+1];
            
            for(int j = start; j < end; j++){
                nums[j] = i;
            }
        }
    }
}