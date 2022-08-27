class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if not amount:
            return 0
    
        results = [None for _ in range(amount + 1)]
        
        for coin in coins:
            if coin < len(results):
                results[coin] = 1
            
        for i in range(1, len(results)):
            
            if not results[i]:
                possible = []
                for coin in coins:
                    if i > coin and results[i - coin] != -1:
                        possible += [results[i-coin] + 1]
                if possible:
                    results[i] = min(possible)
                else:
                    results[i] = -1
                    
        return results[-1]
                    
            
        
                    
                    
        