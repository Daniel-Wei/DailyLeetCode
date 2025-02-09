class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Long, Long> hm = new HashMap<Long, Long>();
        long n = nums.length;
        long good = 0;

        for(int i = 0; i < nums.length; i++){
            long curr = nums[i] - i;

            if(hm.containsKey(curr)){
                good += hm.get(curr);
            }

            hm.put(curr, hm.getOrDefault(curr, 0l) + 1);
        }

        return n * (n - 1) / 2 - good;
    }
}