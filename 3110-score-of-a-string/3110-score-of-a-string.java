class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        char[]chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++){
            res += Math.abs((int)chars[i + 1] - (int)chars[i]);
        }
        
        return res;
    }
}