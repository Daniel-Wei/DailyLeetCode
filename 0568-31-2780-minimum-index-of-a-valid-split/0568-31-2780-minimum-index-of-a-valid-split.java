class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int dominant = -1;
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

	
        for(int num : nums) {
            int prevFreq = freq.getOrDefault(num, 0);
            
            if(prevFreq + 1 > n / 2) {
                dominant = num;
                break;
            }
                
            freq.put(num, prevFreq + 1);
        }
        
        List<Integer> dominantIndices = new ArrayList<Integer>();

        for(int i = 0; i < n; i++) {
            if(nums.get(i) == dominant) {
                dominantIndices.add(i);
            }
        }
        
        int count = dominantIndices.size();

        for(int i = 0; i < count; i++) {
            int index = dominantIndices.get(i);

            if(i + 1 > (index + 1) / 2 && (count - 1 - i) > (n - index - 1) / 2) {
                return index;
            }
        }

        return -1;

    }
}