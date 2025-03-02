class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        res.add(new ArrayList<Integer>());
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            List<Integer> lst = new ArrayList<Integer>();
            lst.add(nums[i]);
            backtrack(i + 1, nums, lst);
        }

        return res;
    }

    private void backtrack(int index, int[] nums, List<Integer> lst){
        List<Integer> temp = new ArrayList<Integer>();
        for(int num : lst){
            temp.add(num);
        }
        res.add(temp);

        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }else{
                lst.add(nums[i]);
                backtrack(i + 1, nums, lst);
                lst.removeLast();
            }
            
        }
    }
}