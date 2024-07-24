class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Character, Character> m = new HashMap<Character, Character>();
        
        for(int i = 0; i < mapping.length; i++){
            m.put(Character.forDigit(i, 10), Character.forDigit(mapping[i], 10));
        }
        
        HashMap<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        
        for(int n : nums){
            String str = String.valueOf(n);
            StringBuilder mappedStr = new StringBuilder();
            
            for (char c : str.toCharArray()) {
                mappedStr.append(m.get(c));
            }
            
            int number = Integer.parseInt(mappedStr.toString());
            numsMap.put(n, number);
        }
        
        return Arrays.stream(nums)
                     .boxed()
                     .sorted((a, b) -> numsMap.get(a) - numsMap.get(b))
                     .mapToInt(n -> n)
                     .toArray();
    }
}