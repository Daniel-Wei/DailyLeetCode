class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        if abs(target) > sum(nums):
            return 0
        
        # 将负数也看作正数 整体上移
        memo = [[0 for _ in range(sum(nums) * 2 + 1)] for _ in range(len(nums))]
        
        # 考虑为0的情况 +=1 而不是 = 1
        memo[0][sum(nums) - nums[0]] += 1
        memo[0][sum(nums) + nums[0]] += 1
        
        total = sum(nums) * 2 + 1
        
        for i in range(1, len(nums)):
            num = nums[i]
            
            ### [1, 1, 1]
            for curr in range(total):
                # curr实际代表的情况 num = 1
                ## 1.curr = curr index = 0 实际代表 - 3
                ## curr + num 代表 index 1，实际是之前的 -2
                ## -2[] - 1
                
                ## 2.curr = curr index = 3 实际代表 0
                ## curr + num 代表 index 4，实际是之前的 1
                ## 1[] - 1
                
                ## 3.curr = curr index = 4, 实际代表 1
                ## curr + num 代表 index 5，实际是之前的 2
                ## 2[] - 1
                
                ## 总结
                ## curr是现在的和 curr+num是之前的和
                ## += 求得的是 之前的和 - num的情况
                
                if curr + num < total:
                    memo[i][curr] += memo[i-1][curr + num]
                    
                    
                # curr实际代表的情况 num = 1
                ## 1.curr = curr index = 1 实际代表 - 2
                ## curr - num 代表 index 0，实际是之前的 -3
                ## -3[] + 1 ()
                
                ## 2.curr = curr index = 3 实际代表 0
                ## curr - num 代表 index 2，实际是之前的 -1
                ## -1[] + 1
                
                ## 3.curr = curr index = 5, 实际代表 2
                ## curr + num 代表 index 4，实际是之前的 1
                ## 1[] + 1
                
                ## 总结
                ## curr是现在的和 curr-num是之前的和
                ## += 求得的是 之前的和 + num的情况
                
                if curr - num >= 0:
                    memo[i][curr] += memo[i - 1][curr - num]
                
           
        return memo[-1][target + sum(nums)]
                
                
        
                    
            
            
        
                
            
        