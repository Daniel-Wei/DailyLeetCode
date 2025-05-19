class Solution {
    public String triangleType(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        for(int num : nums){
            if(sum <= num * 2){
                return "none";
            }
        }

        boolean eq1 = nums[0] == nums[1];
        boolean eq2 = nums[1] == nums[2];
        boolean eq3 = nums[0] == nums[2];

        if(eq1 && eq2 && eq3){
            return "equilateral";
        }

        if(!eq1 && !eq2 && !eq3){
            return "scalene";
        }

        return "isosceles";
    }
}