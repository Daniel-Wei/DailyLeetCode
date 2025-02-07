class Solution {
    public int partitionString(String s) {
        int[] lastSeenIndices = new int[26];
        Arrays.fill(lastSeenIndices, -1);
        int partitionIndex = -1;
        int res = 1;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(lastSeenIndices[c - 'a'] >= 0 && partitionIndex <= lastSeenIndices[c - 'a']){
                res++;
                partitionIndex = i;
            }

            lastSeenIndices[c - 'a'] = i;
        }

        return res;

    }
}