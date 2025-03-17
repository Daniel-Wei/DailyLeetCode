class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
		int count = 1;
		int curr = nums[0];

		for(int i = 1; i < nums.length; i++){
			if(nums[i] == curr){
				count++;
			}else{
				if(count % 2 != 0){
					return false;
				}else{
					count = 1;
					curr = nums[i];
				}
			}
		}

		return count % 2 == 0;
    }
}