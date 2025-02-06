class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
        int res = 0;

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int k = nums[i] * nums[j];
                int freq = ht.getOrDefault(k, 0) + 1;
                ht.put(k, freq);

                res += (freq - 1) * 8;
            }
        }

        return res;
    }
}