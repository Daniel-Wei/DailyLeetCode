class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int n = mat[0].length;
        int currMax = 0;
        int maxSum = 0;
        int currMin = 70;
        int minSum = 0;
        

        for(int num : mat[0]){
            currMax = Math.max(currMax, num);
            currMin = Math.min(currMin, num);
        }

        maxSum += currMax;
        minSum += currMin;
        boolean[] prev = new boolean[maxSum + 1];

        for(int num : mat[0]){
            prev[num] = true;
        }
        


        for(int i = 1; i < m; i++){
            currMax = 0;
            currMin = 70;

            for(int num : mat[i]){
                currMax = Math.max(currMax, num);
                currMin = Math.min(currMin, num);
            }

            maxSum += currMax;
            minSum += currMin;
            boolean[] curr = new boolean[maxSum + 1];
            
            for(int num : mat[i]){
                for(int j = 1; j < prev.length; j++){
                    if(prev[j]){
                        curr[j + num] = true;
                    }
                }
            }
            prev = curr;
        }
        
        int result = Math.min(Math.abs(minSum - target), Math.abs(maxSum - target));

        for(int i = minSum + 1; i < prev.length - 1; i++){
            if(prev[i]){
                if(i == target){
                    return 0;
                }
                result = Math.min(Math.abs(i - target), result);
            }
        }
        return result;
    }


}