class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        if abs(target) > sum(nums):
            return 0
        memo = [[0 for _ in range(sum(nums) * 2 + 1)] for _ in range(len(nums))]
        
        memo[0][sum(nums) - nums[0]] += 1
        memo[0][sum(nums) + nums[0]] += 1
        
        total = sum(nums) * 2 + 1
        
        for i in range(1, len(nums)):
            num = nums[i]
            
            for curr in range(total):
                if curr + num < total:
                    memo[i][curr] += memo[i-1][curr + num]
                if curr - num >= 0:
                    memo[i][curr] += memo[i - 1][curr - num]
                
           
        return memo[-1][target + sum(nums)]
                
                
        
                    
            
            
        
                
            
        