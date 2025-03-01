class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] leftCount = new long[n];
        long[] rightCount = new long[n];

        long[] leftSum = new long[n];
        long[] rightSum = new long[n];
        long[] res = new long[n];

        HashMap<Long, Long> count = new HashMap<>();
        HashMap<Long, Long> sum = new HashMap<>();

        for(int i = 0; i < n; i++){
            long num = nums[i];
            
            long c = count.getOrDefault(num, 0l);
            c++;
            count.put(num, c);
            leftCount[i] = c;

            long s = sum.getOrDefault(num, 0l);
            s += i;
            sum.put(num, s);
            leftSum[i] = s;
        }

        count = new HashMap<>();
        sum = new HashMap<>();


        for(int i = n - 1; i >= 0; i--){
            long num = nums[i];
            
            long c = count.getOrDefault(num, 0l);
            c++;
            count.put(num, c);
            rightCount[i] = c;

            long s = sum.getOrDefault(num, 0l);
            s += i;
            sum.put(num, s);
            rightSum[i] = s;
        }

        for(int i = 0; i < n; i++){
            long num = nums[i];
            res[i] = Math.abs(leftSum[i] - leftCount[i] * i) + Math.abs(rightSum[i] - rightCount[i] * i);
        }

        return res;
    }
}