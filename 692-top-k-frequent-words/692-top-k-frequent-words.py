class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        freq = {}
        freqlst = []
        for word in words:
            if word in freq:
                freq[word] += 1
            else:
                freq[word] = 1
        
        for word in set(words):
            freqlst += [[word, freq[word]]]
        
        sortedlst = sorted(freqlst, key = lambda x: x[0])
        sortedlst = sorted(sortedlst, key = lambda x: x[1], reverse = True)
        res = []
        print(sortedlst)
        
        for i in range(k):
            res += [sortedlst[i][0]]
            
        return res
            
            