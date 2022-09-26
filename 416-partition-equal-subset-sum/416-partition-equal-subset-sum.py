class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 != 0:
            return False
        
        memo = [True] + [False for _ in range(sum(nums) // 2)] 
        
        for num in nums:
            for curr in range(sum(nums)//2, num - 1, -1):
                memo[curr] = memo[curr] or memo[curr - num]
                
        return memo[-1]
            
        
       
        
       
        