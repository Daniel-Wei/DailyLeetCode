

class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        freq = {}
        
        for word in words:
            if word in freq:
                freq[word] += 1
            else:
                freq[word] = 1
                
# 不能使用heapq 的 nlargest， 其他相同freq但是lexicograpgical order更小的可能被忽略  
              
#          for word in set(words):
#             heapq.heappush(h, (freq[word], word))
            
#         res = heapq.nlargest(k, h)
#         res = sorted(res, key = lambda x : x[1])
#         res = sorted(res, key = lambda x : x[0], reverse = True) 
        
#         print(res)


        res = []

        for word in set(words):
            res += [[word, freq[word]]]
        
        
#       因为最终的排列顺序是先freq再lexicographical order
#       所以sorted的使用顺序是先lexicographical order再freq
        res = sorted(res, key = lambda x : x[0])
        res = sorted(res, key = lambda x: x[1], reverse = True)
        
        return [item[0] for item in res[:k]]
            
        
        
#         freq = {}
#         freqlst = []
#         for word in words:
#             if word in freq:
#                 freq[word] += 1
#             else:
#                 freq[word] = 1
        
#         for word in set(words):
#             freqlst += [[word, freq[word]]]
        
#         sortedlst = sorted(freqlst, key = lambda x: x[0])
#         sortedlst = sorted(sortedlst, key = lambda x: x[1], reverse = True)
#         res = []
#         print(sortedlst)
        
#         for i in range(k):
#             res += [sortedlst[i][0]]
            
#         return res
            
            