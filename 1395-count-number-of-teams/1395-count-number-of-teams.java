class Solution {
    public int numTeams(int[] rating) {
        if(rating.length < 3){
            return 0;
        }
        
        int n = rating.length;
        int res = 0;
        
        HashMap<Integer, Integer> asc = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> desc = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(rating[i] < rating[j]){
                    asc.put(i, asc.getOrDefault(i, 0) + 1);
                }else{
                    desc.put(i, desc.getOrDefault(i, 0) + 1);
                    
                }
            }
        }
        
        for(int i = 0; i < n - 2; i++){
            for(int j = i+1; j < n - 1; j++){
                if(rating[i] < rating[j]){
                    res += asc.getOrDefault(j, 0);
                }else{
                    res += desc.getOrDefault(j, 0);
                }
            }
        }
        
        return res;
        
    }
}
           