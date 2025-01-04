class Solution {
    public int countPalindromicSubsequence(String s) {
        HashSet<Character> letters = new HashSet<Character>();
        char[] charArr = s.toCharArray();
        int res = 0;

        for(char c : charArr){
            letters.add(c);
        }

        for(Character l : letters){
            int first = -1;
            int last = -1;

            for(int i = 0; i < charArr.length; i++){
                char c = charArr[i];
                if(l == c){
                    if(first == -1){
                        first = i;
                    }else{
                        last = i;
                    }
                }
            }

            HashSet<Character> chars = new HashSet<Character>();

            for(int j = first + 1; j < last; j++){
                chars.add(charArr[j]);
            }

            res += chars.size();
        }

        return res;
    }
}