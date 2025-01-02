class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefixSum = new int[n];
        HashSet<Character> vowels = new HashSet<Character>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        String first = words[0];

        if(vowels.contains(first.charAt(0)) && vowels.contains(first.charAt(first.length() - 1))){
            prefixSum[0] = 1;
        }

        for(int i = 1; i < n; i++){
            String w = words[i];

            if(vowels.contains(w.charAt(0)) && vowels.contains(w.charAt(w.length() - 1))){
                prefixSum[i] = prefixSum[i - 1] + 1;
            }else{
                prefixSum[i] = prefixSum[i - 1];
            }
        }

        int len = queries.length;

        int[] res = new int[len];
        
        for(int i = 0; i < len; i++){
            int[] q = queries[i];

            if(q[0] == 0){
                res[i] = prefixSum[q[1]];
            }else{
                res[i] = prefixSum[q[1]] - prefixSum[q[0] - 1];
            }
        }

        return res;
        
    }
}