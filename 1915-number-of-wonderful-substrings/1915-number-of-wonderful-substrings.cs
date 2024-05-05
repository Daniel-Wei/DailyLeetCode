// https://www.youtube.com/watch?v=P6i1qj8DMZk

public class Solution {
    public long WonderfulSubstrings(string word) {
        long[]cnt = new long[1024];
        long res = 0;
        cnt[0] = 1;
        long mask = 0;
        
        foreach(char c in word){
            // 1 << x is in binary, 1 to the left of x bits
            // ^ means XOR, Exclusive OR (Same is False, Diff is True)
            mask ^= 1 << (c - 'a');
            
            // if such mask has occured before, like curr index is i and previous index is j
            // then in the the substring word[j+1, i] (both ends inclusive)
            // for each letter, its occurenece times to be even, as odd + even is odd, even + even is even
            res += cnt[mask];

            for(int i = 0; i < 10; i++){
                // Similarily, if we fick one letter's occurence times (odd -> even, even -> odd)
                // if such new mask has occured before, like curr index is i and previous index is j
                // then in the the substring word[j+1, i] (both ends inclusive)
                // for all letters, its occurence times has to be even, as odd + even is odd, and even + even is even
                // well for this specific letter, its occurence times in substring is odd, as after we flicked it, it is even
                res += cnt[mask ^ (1 << i)];
            }
            cnt[mask]++;
        }
       return res;
    }
}