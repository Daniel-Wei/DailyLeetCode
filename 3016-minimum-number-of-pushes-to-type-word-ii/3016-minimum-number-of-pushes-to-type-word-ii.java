class Solution {
    public int minimumPushes(String word) {
        int[]freq = new int[26];
        
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            freq[c - 'a'] += 1;
        }
        
        Arrays.sort(freq);
        
        int k = 8;
        int res = 0;
        
        for(int i = 25; i >= 0; i--){
            if(freq[i] != 0){
                res += freq[i] * (k / 8);
                k++;
            }
        }
        
        return res;
    }
}