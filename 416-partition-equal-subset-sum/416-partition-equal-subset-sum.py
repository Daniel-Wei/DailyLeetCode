class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 != 0:
            return False
        
        memo = [True] + [False for _ in range(sum(nums) // 2)] 
        
        
        # 如果curr是正序
        # for example 第一个数是2
        # memo[i] when i % 2 == 0 都会在第一个数的循环中等于True
        
        # 如果curr是倒序
        # for example 第一个数是2 sum是10
        # 只有memo[2] 会改变成True
        
        # 因为方法是 测试当前curr可不可能是之前数的和 或者是当前的num数值本身
        # curr正序的话 当前的num数值会作为可能的和 在memo里记为True 并被继续利用
        # curr倒叙的话 当前的num数值 只会在最后 才会作为可能的和 在memo里记为True
        for num in nums:
            for curr in range(sum(nums)//2, num - 1, -1):
                memo[curr] = memo[curr] or memo[curr - num]
                
        return memo[-1]
            
        
       
        
       
        