class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, -1);

        int curr = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                curr -= 1;
            }else{
                curr += 1;
            }

            if(hm.containsKey(curr)){
                maxLength = Math.max(maxLength, i - hm.get(curr));
            }else{
                hm.put(curr, i);
            }
        }

        return maxLength;
    }
}