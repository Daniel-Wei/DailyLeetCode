class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<String>();
        Arrays.sort(words, ((a, b) -> a.length() - b.length()));

        int[][] lpsRecords = new int[words.length][];

        for(int i = 0; i < n; i++){
            lpsRecords[i] = constructLongestPrefixSuffix(words[i]);
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(algoKMP(lpsRecords[i], words[i], words[j])){
                    res.add(words[i]);
                    break;
                }
            }
        }

        return res;
    }

    public int[] constructLongestPrefixSuffix (String word){
        int n = word.length();
        int[] lps = new int[n];

        int i = 0;
        int j = 1;

        while(j < n){
            if(word.charAt(j) == word.charAt(i)){
                lps[j] = lps[i] + 1;
                i++;
                j++;
            }else{
                if(i == 0){
                    j++;
                }else{
                    i = lps[i - 1];
                }
            }
        }

        return lps;
    }

    public boolean algoKMP(int[] lps, String pattern, String word){

        int i = 0; 
        int j = 0;
        boolean res = false;
        
        while(j < word.length()){
            if(pattern.charAt(i) == word.charAt(j)){
                if(i == pattern.length() - 1){
                    res = true;
                    break;
                }else{
                    i++;
                    j++;
                }
            }else{
                if(i == 0){
                    j++;
                }else{
                    i = lps[i - 1];
                }
            }
        }

        return res;
    }
}