class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }

        int oddCount = 0;
        
        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(count[i] != 0 && count[i] % 2 != 0){
                oddCount++;
            }
        }

        return oddCount <= k;
    }
}