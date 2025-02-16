class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        

        for(int i = 0; i < n; i++){
            HashMap<Integer, Boolean> m = new HashMap<Integer, Boolean>();
            m.put(nums[i], true);
            res += backtrack(m, i + 1, k, nums, 1, nums[i]);
            
        }
        
        return res;
       
    }
    
    private int backtrack(HashMap<Integer, Boolean> m, int i, int k, int[] nums, int count,int curr){

        if(i < nums.length){
            int conflict = nums[i] - k;
            
            if(!m.containsKey(conflict) || !m.get(conflict)){

                //1. add
                m.put(nums[i], true);
                count++;
                count = backtrack(m, i + 1, k, nums, count, curr);

            }

            //2. not add
            // notice: could be mutliple same nums
            if(nums[i] != curr){
                m.put(nums[i], false);
            }
            count = backtrack(m, i + 1, k, nums, count, curr);
        }
        

        return count;
    }
}