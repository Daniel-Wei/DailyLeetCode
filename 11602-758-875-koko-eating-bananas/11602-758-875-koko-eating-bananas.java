class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n = piles.length;
        int low = 1;
        int high = piles[n - 1];
        int res = Integer.MAX_VALUE;
        int mid = -1;

        while(low <= high){
            mid = (low + high) / 2;

            if(!getHours(mid, piles, h)){
                low = mid + 1;
            }else{
                res = Math.min(res, mid);
                high = mid - 1;
            }
        }

        return res;
    }

    private boolean getHours(int speed, int[] piles, int h){
        int hours = 0;
        for(int p: piles){
            hours += p / speed;
            if(p % speed != 0){
                hours++;
            }

            if(hours > h){
                return false;
            }
        }

        return true;
    }
}