class Solution {
    public int maxProduct(int[] nums) {
        int low = nums[0];
        int high = nums[0];
        int res = high;

        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int p1 = num * low;
            int p2 = num * high;

            low = Math.min(p1, p2);
            low = Math.min(low, num);
            high = Math.max(p1, p2);
            high = Math.max(high, num);


            res = Math.max(res, high);
        }

        return res;
    }
}