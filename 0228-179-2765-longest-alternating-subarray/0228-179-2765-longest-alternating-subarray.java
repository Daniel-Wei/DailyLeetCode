class Solution {
    public int alternatingSubarray(int[] nums) {
        int res = -1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i - 1] == 1){
                int k = 2;
                int j = i + 1;
                
                while(j < nums.length){
                    if((k % 2 == 0 && nums[j] - nums[j - 1] == -1) || (k % 2 == 1 && nums[j] - nums[j - 1] == 1)){
                        k++;
                        j++;
                    }else{
                        break;
                    }
                }

                res = Math.max(res, k);
                i = j - 1;
            }
        }

        return res;

    }
}