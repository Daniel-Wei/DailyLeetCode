class Solution {
    public int minimizedMaximum(int n, int[] quantities){
		int low = 1;
		Arrays.sort(quantities);
		int high = quantities[quantities.length - 1];
		int res= high;
		
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(canAssign(n, quantities, mid)){
                res = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
            
        }

        return res;
 
	}

	private boolean canAssign(int n, int[] quantities, int volume){
		int k = 0;
		for(int q: quantities){
			k += (q + volume - 1) / volume;

			if(k > n){
				return false;
			}
		}

		return true;
	}

}