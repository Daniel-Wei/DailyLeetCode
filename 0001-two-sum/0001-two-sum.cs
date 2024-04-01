public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> dict = new Dictionary<int, int>();
        int[]res = new int[2];
        for(int i = 0; i < nums.Length; i++){
            int num = nums[i];
            if(dict.ContainsKey(target - num)){
                res[0] = dict[target - num];
                res[1] = i;
                break;
            }else if(!dict.ContainsKey(num)){
                dict.Add(num, i);
            }
        }
        return res;
        
    }
}