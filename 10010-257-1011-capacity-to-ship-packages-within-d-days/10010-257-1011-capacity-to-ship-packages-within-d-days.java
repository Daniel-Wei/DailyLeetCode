class Solution {
    public int shipWithinDays (int[] weights, int days){
		int low = 1;
        int high = 0;

        for(int w : weights){
            low = Math.max(low, w);
            high += w;
        }


        while(low <= high){
            int mid = (low + high) / 2;

            if(canShip(days, weights, mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;
	}

	private boolean canShip(int days, int[] weights, long capacity){
		int k = 1;
		int currSum = 0;

		for(int i = 0; i < weights.length; i++){
			if(currSum + weights[i] > capacity){
				currSum = weights[i];
				k++;
				if(k > days){
					return false;
				}
			}else{
				currSum += weights[i];
			}
		}
		return true;
	}

}