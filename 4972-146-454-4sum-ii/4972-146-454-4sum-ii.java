class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> m1 = new HashMap<>();
        for(int i : nums1){
            for(int j : nums2){
                int freq = m1.getOrDefault(i + j, 0);
                m1.put(i + j, freq + 1);
            }
        }

        int count = 0;

        HashMap<Integer, Integer> m2 = new HashMap<>();
        for(int i : nums3){
            for(int j : nums4){
                int freq = m1.getOrDefault(-i-j, 0);
                count += freq;
            }
        }

        return count;
    }
}