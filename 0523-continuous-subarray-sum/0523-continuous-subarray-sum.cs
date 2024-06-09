public class Solution {
    public bool CheckSubarraySum(int[] nums, int k) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        dict.Add(0, -1);
        int sum = 0;
        
        for(int i = 0; i < nums.Length; i++){
            int num = nums[i];
            sum += num; 
            
            // Deal with Modulus for negative numbers
            int curr = (sum % k + k) % k;
            
            if(dict.ContainsKey(curr)){
                if(i - dict[curr] > 1){
                    return true;
                }
            }else{
                dict.Add(curr, i);
            }
        }
        
        return false;
    }
}