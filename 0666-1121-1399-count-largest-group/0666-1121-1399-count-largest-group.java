class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int maxSize = 0;

        for(int i = 1; i <= n; i++){
            int digitsSum = 0;
            int num = i;

            while(num != 0){
                digitsSum += num % 10;
                num /= 10;
            }

            int size = hm.getOrDefault(digitsSum, 0) + 1;
            maxSize = Math.max(maxSize, size);

            hm.put(digitsSum, size);
        }

        
        int count = 0;

        for(int val : hm.values()){
            if(val == maxSize){
                count++;
            }
        }

        return count;
    }
}