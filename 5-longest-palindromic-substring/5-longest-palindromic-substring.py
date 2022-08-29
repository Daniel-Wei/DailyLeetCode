class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxLen = 1
        n = len(s)
        
        start= 0
        def getLen(l, r):
            if r >= n or s[l] != s[r]:
                return 0
            while l >= 0 and r < n and s[l] == s[r]:
                l -= 1
                r += 1
                
            return  r - l - 1
        
        for i in range(n):
            curr = max(getLen(i, i), getLen(i, i+ 1))
            
            if curr > maxLen:
                maxLen = curr
                start = i - (curr-1) // 2 
                

            
                
        return s[start : start + maxLen]

                
            
        
            
       
        
                
        
        