public class Solution {
    public bool CanPartition(int[] nums) {
        if(nums.Sum() % 2 != 0){
            return false;
        }
        int target = nums.Sum()/2;
        
        if(nums.Contains(target)){
            return true;
        }

        bool[] dpMemo = new bool[target + 1];
        dpMemo[0] = true;
        foreach(int num in nums){
            for(int i = target; i >= num; i--){
                dpMemo[i] = dpMemo[i] || dpMemo[i - num];
            }
        }
        return dpMemo[target];
    }
}