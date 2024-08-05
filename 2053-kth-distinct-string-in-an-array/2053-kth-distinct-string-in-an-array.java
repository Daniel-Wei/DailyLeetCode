class Solution {
    public String kthDistinct(String[] arr, int k) {
        int i = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        String res = "";
        
        for(String str : arr){
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        
        if(k > hm.size()){
            return res;
        }
        
        for(String str: arr){
            if(hm.get(str) == 1){
                i++;
                if(i == k){
                    res = str;
                    break;
                }
            }
        }
        
        return res;
    }
}