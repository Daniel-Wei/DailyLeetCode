class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] twoIterations = new int[2 * n - 1];
        twoIterations[n - 1] = nums[n - 1];

        for(int i = 0; i < n -1; i++){
            twoIterations[i] = nums[i];
            twoIterations[i + n] = nums[i];
        }

        Stack<Integer> s = new Stack<Integer>();
        int[] result = new int[n];

        for(int i = twoIterations.length - 1; i >= 0; i --){
            while(!s.isEmpty() && s.peek() <= twoIterations[i]){
                s.pop();
            }

            if(i < n){
                if(s.isEmpty()){
                    result[i] = -1;
                }else{
                    result[i] = s.peek();
                }
            }

            s.push(twoIterations[i]);
        }

        return result;
    }
}