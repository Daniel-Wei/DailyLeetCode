class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies); // O(n)
        int res = 0;
        int low = 1;
        int high = candies[candies.length - 1];
        
        while(low <= high){
            int mid = (low + high) / 2;
	        long count = 0;
   	
            for(int c : candies){
                count += c / mid;
            }

            if(count >= k){
                low = mid + 1;
                res = Math.max(res, mid);
            }else{
                high = mid - 1;
            }
        }

        return res;
    }
}
