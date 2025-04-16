class Solution {
    public long countGood(int[] nums, int k) {
        long result = 0;
        HashMap<Integer, Long> hm = new HashMap<Integer, Long>();
        long pairs = 0;
        int i = 0;
        int l = 0;

        while(i < nums.length){
            int num = nums[i];
            long freq = hm.getOrDefault(num, 0l);
            pairs += freq;
            hm.put(num, freq + 1);
            while(pairs >= k){
                // all subarrays starting at l end at/after i are 'good'
                result += nums.length - i;
                int left = nums[l];
                long leftFreq = hm.get(left);
                pairs -= leftFreq - 1;
                hm.put(left, leftFreq - 1);

                l++;
            }
            
            i++;
        }

        return result;
    }
}