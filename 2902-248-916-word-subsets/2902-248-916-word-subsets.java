class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] counter = new int[26];
        int[] tmp = new int[26];
        boolean universal = true;
        List<String> res = new ArrayList<String>();

        for(int i = 0; i < words2.length; i++){
            tmp = getCounter(words2[i]);

            for(int j = 0; j < 26; j++){
                counter[j] = Math.max(counter[j], tmp[j]);
            }
        }

        for(int i = 0; i < words1.length; i++){
            tmp = getCounter(words1[i]);
            universal = true;

            for(int j = 0; j < 26; j++){
                if(counter[j] > tmp[j]){
                    universal = false;
                    break;
                }
            }

            if(universal){
                res.add(words1[i]);
            }
        }

        return res;
    }

    private int[] getCounter(String w){
        int[] counter = new int[26];

        for(char c : w.toCharArray()){
            counter[c - 'a']++;
        }

        return counter;
    }
}