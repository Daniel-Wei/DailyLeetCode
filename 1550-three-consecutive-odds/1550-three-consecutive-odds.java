class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        
        for(int num : arr){
            if(num % 2 == 1){
                if(count == 2){
                    return true;
                }else{
                    count ++;
                }
            }else{
                count = 0;
            }
        }
        
        return false;
    }
}