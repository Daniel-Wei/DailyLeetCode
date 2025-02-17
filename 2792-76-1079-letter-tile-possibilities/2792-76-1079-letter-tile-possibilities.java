class Solution {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        List<String> strs = new ArrayList<String>();
        strs.add("");
        HashSet<String> set = new HashSet<String>();

        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            strs = backtrack(c, strs, set);
        }


        return strs.size() - 1;
    }

    private List<String> backtrack(char c, List<String> strs, HashSet<String> set) {
        List<String> next = new ArrayList<String>();

        for(String s : strs){
            next.add(s);
            for(int i = 0; i <= s.length(); i++){
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, c);
                String str = sb.toString();
                
                

                if(!set.contains(str)){
                   
                    set.add(str);
                    next.add(str);
                }
            }

        }

        

        return next;
    }
}