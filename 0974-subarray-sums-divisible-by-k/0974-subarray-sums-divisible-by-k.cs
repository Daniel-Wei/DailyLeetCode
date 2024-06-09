public class Solution {
    public int SubarraysDivByK(int[] nums, int k) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        int sum = 0;
        int res = 0;
        dict.Add(0, 1);
        
        foreach(int num in nums){
            sum += num;
            
            // Deal with Modulus for negative numbers
            int curr = (sum % k + k) % k;
            
            
            // if prefix[i] % k == prefix[j] % k
            // then nums[i..j] % k == 0
            if(dict.ContainsKey(curr)){
                res += dict[curr];
                dict[curr] += 1;
            }else{
                dict.Add(curr, 1);
            }
        }
        
        return res;
    }
}