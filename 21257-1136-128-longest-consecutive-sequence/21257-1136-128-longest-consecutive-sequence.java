class Solution {
    public int longestConsecutive(int[] nums) {
        int cnt = 1;
        int curr = 1;
        int n = nums.length;

        if(n == 0){
            return 0;
        }
        Arrays.sort(nums);

        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i - 1] == 1){
                curr++;
            }else if(nums[i] - nums[i - 1] == 0){
                continue;
            }
            else{
                cnt = Math.max(cnt, curr);
                curr = 1;
            }
        }

        return Math.max(cnt, curr);
    }
}