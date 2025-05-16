class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] sizes = new int[n];
        int maxResSize = 0;
        int maxResIdx = 0;

        int[] parents = new int[n];
        
        Arrays.fill(sizes, 1);
        Arrays.fill(parents, -1);
    

        for(int i = 0; i < n; i++){
            int maxSize = -1;
            int maxIdx = -1;
            
            for(int j = i - 1; j >= 0; j--){
                if(groups[i] != groups[j] 
                    && words[i].length() == words[j].length() 
                    && hammingDistanceOne(words[i], words[j])
                    && sizes[j] > maxSize)
                {
                    maxSize = sizes[j];
                    maxIdx = j;
                }
            }

            if(maxSize > 0){
                sizes[i] = maxSize + 1;
                parents[i] = maxIdx;

                if(maxSize > maxResSize){
                    maxResSize = maxSize;
                    maxResIdx = i;
                }
            }
        }


        List<String> res = new ArrayList<String>();

        while(parents[maxResIdx] != -1){
            res.add(0, words[maxResIdx]);
            maxResIdx = parents[maxResIdx];
        }

        res.add(0, words[maxResIdx]);
        

        return res;
    }

    private boolean hammingDistanceOne(String w1, String w2){
        boolean diff = false;

        for(int idx = 0; idx < w1.length(); idx++){
            if(w1.charAt(idx) != w2.charAt(idx)){
                if(diff){
                    return false;
                }

                diff = true;
            }
        }

        if(diff){
            return true;
        }

        return false;
    }
}