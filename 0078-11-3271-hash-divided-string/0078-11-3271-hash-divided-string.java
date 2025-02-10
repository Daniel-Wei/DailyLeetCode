class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int currHash = 0;
        for(int i = 0; i < s.length(); i += k){
            for(int j = i; j < i + k; j++){
                currHash += s.charAt(j) - 'a';
            }

            currHash %= 26;
            sb.append((char)('a' + currHash));
            currHash = 0;
        }

        return sb.toString();
    }
}