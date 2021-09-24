class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        memo = {}
        
        def dp(l, r, prev):
            if (l, r, prev) not in memo:
                if l >= r:
                    return 0
                if s[l] == s[r] and (s[l] != prev):
                    return 2 + dp(l + 1, r - 1, s[l])
                memo[(l, r, prev)] = max(dp(l + 1, r, prev), dp(l, r - 1, prev))
            return memo[(l, r, prev)]
        
        return dp(0, len(s) - 1, '')