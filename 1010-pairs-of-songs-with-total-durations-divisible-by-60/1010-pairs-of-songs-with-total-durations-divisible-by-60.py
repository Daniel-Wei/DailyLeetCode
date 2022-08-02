class Solution:
    
    ### 实际上就是 每次新得到一个reminder 和现存对应的60-reminder的数量配对即可
    ### 比如20 40 20 40
    def numPairsDivisibleBy60(self, time):
        c = [0] * 60
        res = 0
        for t in time:
            res += c[-t % 60]
            c[t % 60] += 1
        return res
    
    
#     def numPairsDivisibleBy60(self, time: List[int]) -> int:
#         reminders = [0 for _ in range(60)]
        
#         for t in time:
#             reminders[t%60] += 1
            
#         pairs = 0
        
#         if reminders[0] > 1:
#             k = reminders[0]
#             curr = 1
#             while k:
#                 curr *= k
#                 k -= 1
#             curr /= 2
        
#             pairs += int(curr)
                
            
#         for i in range(1, 30):
#             if reminders[i] and reminders[60-i]:
#                 curr = reminders[i] * reminders[60-i] 
#                 pairs += curr
    
#         if reminders[30] > 1:
#             k = reminders[30]
#             curr = 1
#             while k:
#                 curr *= k
#                 k -= 1
#             curr /= 2
#             pairs += int(curr)
                
                
#         return pairs
            
        