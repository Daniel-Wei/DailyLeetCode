class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        Integer[]indices = new Integer[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparing(i -> convert(mapping, nums[i])));
        
        int[]res = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            res[i] = nums[indices[i]];
        }
        
        return res;
    }
    
    private int convert(int[]mapping, int num){
        if(num == 0){
            return mapping[0];
        }

        int base = 1;
        int n = 0;

        while(num != 0){
            n += mapping[num % 10] * base;
            base *= 10;
            num /= 10;
        }

        return n;
    }
}