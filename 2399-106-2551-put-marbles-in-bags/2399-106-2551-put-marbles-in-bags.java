class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] borders = new int[n - 1];

        for(int i = 1; i < n; i++){
            borders[i - 1] = (weights[i] + weights[i - 1]);
        }

        Arrays.sort(borders);
        
        int minIndex = 0;
        long minSum = 0l;
        int maxIndex = n - 2;
        long maxSum = 0l;

        for(int j = 1; j < k; j++){
            minSum += borders[minIndex];
            maxSum += borders[maxIndex];
            minIndex++;
            maxIndex--;
        }

        return maxSum - minSum;
    }
}