class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> sortedStartWords = new HashSet<>();
        for (String startWord : startWords) {
            char[] chArr = startWord.toCharArray();
            Arrays.sort(chArr);
            String newStartWord = new String(chArr);
            sortedStartWords.add(newStartWord);
        }

        int ans = 0;
        for (String targetWord : targetWords) {
            char[] chArr = targetWord.toCharArray();
            Arrays.sort(chArr);
            String newTargetWord = new String(chArr);

            for (int i = 0; i < newTargetWord.length(); i++) {
                String subStringWord = newTargetWord.substring(0, i) + 
                            newTargetWord.substring(i + 1, newTargetWord.length());
                if (sortedStartWords.contains(subStringWord)) {
                    ans += 1;
                    break;
                }
            }
        }
        return ans;
    }
}