class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        freq.put(0, 1);
        for(int num : nums){
            prefixSum += num;
            
            int reminder = prefixSum % k;
            if(reminder < 0){
                reminder += k;
            }

            int f = freq.getOrDefault(reminder, 0);
            res += f;
            freq.put(reminder, f + 1);
        }
        
        return res;
    }
}