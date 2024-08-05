class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> odds = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                odds.add(i);
            }
        }
        
        int res = 0;
        int size = odds.size();
        
        int l = 0;
        int ls = 0;
        int r = k - 1;
        int rs = 0;
        
        while(r < size){
            if(l != 0){
                ls = odds.get(l) - odds.get(l - 1);
            }else{
                ls = odds.get(l) + 1;
            }
            
            if(r != size - 1){
                rs = odds.get(r + 1) - odds.get(r);
            }else{
                rs = nums.length - odds.get(r);
            }

            res += ls * rs;
            
            l++;
            r++;
        }
        
        return res;
    }
}