class Solution {
    public int minimumLength(String s) {
        int[] counts = new int[26];
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 'a'] ++;
        }

        for(int i = 0; i < 26; i++){
            if(counts[i] != 0){
                if(counts[i] % 2 == 0){
                    res += 2;
                }else{
                    res += 1;
                }
            }
        }

        return res;
    }
}