class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> set = new HashSet<>();
        for (String w : startWords) {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            String newStartWord = new String(chars);
            set.add(newStartWord);
        }

        int res = 0;
        for (String w : targetWords) {
            char[] chars = w.toCharArray();
            Arrays.sort(chars);
            String t = new String(chars);

            for (int i = 0; i < t.length(); i++) {
                String sub = t.substring(0, i) + 
                            t.substring(i + 1, t.length());
                if (set.contains(sub)) {
                    res += 1;
                    break;
                }
            }
        }
        return res;
    }
}