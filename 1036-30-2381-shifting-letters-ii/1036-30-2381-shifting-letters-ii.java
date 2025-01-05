class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        char[]chars = s.toCharArray();
        int[]moves = new int[n];
        String res = "";

        // Example [4, 8, 1]
        // moves[4] += 1 means starting at index 4, shifting forward one more time
        // moves[8] -= 1 means avoiding carrying over the one more shifting forward starting at index 4
        for(int[] shift : shifts){
            if(shift[2] == 0){
                moves[shift[0]] -= 1;
                if(shift[1] + 1 < n){
                    moves[shift[1] + 1] += 1;
                }
            }else{
                moves[shift[0]] += 1;
                if(shift[1] + 1 < n) {
                    moves[shift[1] + 1] -= 1;
                }
            }
        }

        int m = 0;

        for(int i = 0; i < n; i++){
            m = (m + moves[i]) % 26;
            chars[i] += m;

            if(chars[i] > 'z'){
                chars[i] -= 26;
            }

            if(chars[i] < 'a'){
                chars[i] += 26;
            }
        }

        return new String(chars);
    }
}