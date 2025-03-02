class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if(digits.length() == 0){
            return res;
        }
        char[][] mappings = new char[8][4];

        for(int i = 0; i < 5; i++){
            mappings[i][0] = (char)('a' + i * 3);
            mappings[i][1] = (char)('b' + i * 3);
            mappings[i][2] = (char)('c' + i * 3);
            mappings[i][3] = '#';

        } 

        mappings[5][0] = 'p';
        mappings[5][1] = 'q';
        mappings[5][2] = 'r';
        mappings[5][3] = 's';

        mappings[6][0] = 't';
        mappings[6][1] = 'u';
        mappings[6][2] = 'v';
        mappings[6][3] = '#';


        mappings[7][0] = 'w';
        mappings[7][1] = 'x';
        mappings[7][2] = 'y';
        mappings[7][3] = 'z';


        char[] chars = digits.toCharArray();

        backtrack(0, chars, new ArrayList<Character>(), res, mappings);
        
        return res;
    }

    private void backtrack(int index, char[] chars, List<Character> lst, List<String> res, char[][] mappings){

        if(index == chars.length){
            StringBuilder sb = new StringBuilder();
            for(char c : lst){
                sb.append(c);
            }
            res.add(sb.toString());
        }else{
            char[] map = mappings[chars[index] - '0' - 2];

            for(int j = 0; j < 3; j++){
                lst.add(map[j]);
                backtrack(index + 1, chars, lst, res, mappings);
                lst.removeLast();
            }

            if(map[3] != '#'){
                lst.add(map[3]);
                backtrack(index + 1, chars, lst, res, mappings);
                lst.removeLast();
            }
        }
    }
}