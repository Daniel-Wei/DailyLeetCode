class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[]dp = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        
        dp[0] = 0;
        
        for(int i = 0; i < n; i++){
            int prevWidth = books[i][0];
            int currHeight = books[i][1];
            dp[i + 1] = dp[i] + currHeight;
            int prevMaxHeight = currHeight;
            int j = i - 1;
            
            while(j >= 0){
                prevWidth += books[j][0];
                
                if(prevWidth > shelfWidth){
                    break;
                }else{
                    prevMaxHeight = Math.max(prevMaxHeight, books[j][1]);
                    
                    dp[i + 1] = Math.min(dp[i + 1], prevMaxHeight + dp[j]);
                    j--;
                }
            }
        }
        
        return dp[n];
    }
}