class Solution {
    int[] nums;
    Map<Integer, List<Integer>> m = new HashMap<>();
    public Solution(int[] nums) {
        this.nums = nums;
        this.m = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            List<Integer> indices = m.getOrDefault(nums[i], new ArrayList<Integer>());
            indices.add(i);
            m.put(nums[i], indices);
        }
    }
    
    public int pick(int target) {

        if(m.containsKey(target)){
            List<Integer> indices = m.get(target);
            Random r = new Random();
            int index = r.nextInt(indices.size());
            return indices.get(index);
        }

        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */