class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {}
        res = []
        for i, letter in enumerate(s):
            last[letter] = i
            
        left, right = 0, 0
        
        for i, letter in enumerate(s):
            right = max(right, last[letter])
            
            if i == right:
                res += [right - left + 1]
                left = right + 1
                
        return res
            
        
            