class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[]dp = new int[n + 1];
        
        dp[0] = 0;
        
        for(int i = 0; i < n; i++){
            int prevWidth = books[i][0];
            int currHeight = books[i][1];
            
            // dp[i + 1]: books[0..i]的height sum
            // by default, put books[i] on a new shelf
            // - dp[i + 1] = books[0...i] height sum == books[0..i-1] height sum + books[i] height as on a new shelf
            dp[i + 1] = dp[i] + currHeight;
            int prevMaxHeight = currHeight;
            int j = i - 1;
            
            while(j >= 0){
                prevWidth += books[j][0];
                
                if(prevWidth > shelfWidth){
                    break;
                }else{
                    
                    prevMaxHeight = Math.max(prevMaxHeight, books[j][1]);
                    
                    // dp[i + 1] == books[0...i] height sum
                    // == prevMaxHeight + dp[j] == books[j..i] max height + books[0..j-1] height sum
                    dp[i + 1] = Math.min(dp[i + 1], prevMaxHeight + dp[j]);
                    j--;
                }
            }
        }
        
        return dp[n];
    }
}