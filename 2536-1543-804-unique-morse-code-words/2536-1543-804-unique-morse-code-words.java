class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mappings = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
                                ".--","-..-","-.--","--.."};

        HashSet<String> transformations = new HashSet<String>();

        for(String w : words){
            StringBuilder sb = new StringBuilder();

            for(char c : w.toCharArray()){
                sb.append(mappings[c - 'a']);
            }

            transformations.add(sb.toString());
        }

        return transformations.size();
    }
}