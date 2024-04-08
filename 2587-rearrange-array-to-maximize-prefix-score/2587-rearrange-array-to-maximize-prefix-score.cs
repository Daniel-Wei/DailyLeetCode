public class Solution {
    public int MaxScore(int[] nums) {
        // Array.Sort(nums);
        // Array.Reverse(nums);
        Array.Sort(nums, (a, b) => b.CompareTo(a));
        
        // int sum = 0;
        long sum = 0;
        int score = nums.Length;
        
        for(int i = 0; i < nums.Length; i++){
            sum += nums[i];

            if(sum <= 0){
                Console.WriteLine(i);
                score = i;
                break;
            }
        }
        
        return score;
    }
}