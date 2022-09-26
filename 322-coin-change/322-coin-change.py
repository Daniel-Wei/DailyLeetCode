import math
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
#         if not amount:
#             return 0
    
#         results = [None for _ in range(amount + 1)]
        
#         for coin in coins:
#             if coin < len(results):
#                 results[coin] = 1
            
#         for i in range(1, len(results)):
            
#             if not results[i]:
#                 possible = []
#                 for coin in coins:
#                     if i > coin and results[i - coin] != -1:
#                         possible += [results[i-coin] + 1]
#                 if possible:
#                     results[i] = min(possible)
#                 else:
#                     results[i] = -1
                    
#         return results[-1]
        
        if not amount:
            return 0
        
        coinsss = []
        
        res = [-1 for _ in range(amount + 1)]
        
        for coin in coins:
            if coin < len(res):
                res[coin] = 1
            coinsss += [coin]
            
        for curr in range(1, len(res)):
            if res[curr] == -1:
                count = math.inf
                
                for coin in coinsss:
                    if curr > coin and res[curr - coin] != -1:
                        curr_count = res[curr - coin] + 1
                        if curr_count < count:
                            count = curr_count
                            
                if count < math.inf:
                    res[curr] = count
                    
                    
        return res[-1]
                        
                
            
        
        
            
        
                    
                    
        