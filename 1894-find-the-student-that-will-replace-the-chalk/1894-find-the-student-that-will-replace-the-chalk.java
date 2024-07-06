class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long s = k;
        long sum = Arrays.stream(chalk).asLongStream().sum();
        long reminds = s % sum;

        int i = -1;
        
        while(reminds >= 0){
            i++;
            reminds -= chalk[i];
        }
        
        return i;
    }
}