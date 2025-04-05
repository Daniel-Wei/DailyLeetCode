class Solution {
    public int subsetXORSum(int[] nums) {
        List<Integer> prefix = new ArrayList<Integer>();
        prefix.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            List<Integer> next = new ArrayList<Integer>();
            for(int p : prefix){
                next.add(p);
                next.add(p ^ curr);
            }

            next.add(curr);
            prefix = next;
        }

        int result = 0;

        for(int p : prefix){
            result += p;
        }

        return result;
    }
}