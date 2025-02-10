class Solution {
    public boolean isItPossible(String word1, String word2) {
        HashMap<Character, Integer> freq1 = new HashMap(), freq2 = new HashMap(); 
        for (var ch : word1.toCharArray()) freq1.merge(ch, 1, Integer::sum); 
        for (var ch : word2.toCharArray()) freq2.merge(ch, 1, Integer::sum); 
        int sz1 = freq1.size(), sz2 = freq2.size(); 
        for (char c1 = 'a'; c1 <= 'z'; ++c1) 
            for (char c2 = 'a'; c2 <= 'z'; ++c2) 
                if (freq1.getOrDefault(c1, 0) > 0 && freq2.getOrDefault(c2, 0) > 0) 
                    if (c1 == c2) {
                        if (sz1 == sz2) return true; 
                    } else {
                        int cnt1 = sz1, cnt2 = sz2; 
                        if (freq1.getOrDefault(c1, 0) == 1) --cnt1; 
                        if (freq1.getOrDefault(c2, 0) == 0) ++cnt1; 
                        if (freq2.getOrDefault(c1, 0) == 0) ++cnt2; 
                        if (freq2.getOrDefault(c2, 0) == 1) --cnt2; 
                        if (cnt1 == cnt2) return true; 
                    }
        return false; 
    }
}