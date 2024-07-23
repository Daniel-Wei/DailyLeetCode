class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        Integer[]arr = new Integer[nums.length];
        
        
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        return Arrays.stream(nums) // IntStream
            .boxed() // Stream<Integer>
            .sorted((a, b) -> freq.get(a) == freq.get(b) ? b - a : freq.get(a) - freq.get(b)) // Sorting method
            .mapToInt(n -> n) //Integer -> int
            .toArray();
    }
}