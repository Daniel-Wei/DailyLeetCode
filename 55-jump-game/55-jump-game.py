class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        
        
        
        # 仍然有重复性：可能在过程中多次跳到了同一个石头上
        
#         self.jumps = nums
#         self.res = False
#         def helper(curr):
#             if not self.res:
                
#                 if len(self.jumps) - curr <= self.jumps[curr]:
#                     self.res = True
#                 else:
#                     for step in range(1, self.jumps[curr] + 1):
#                         helper(curr + step)
                        
#         helper(0)  
#         return self.res






# 根据一百万原则（10^6）, test case size是10^4， dp O(n^2)有时候会TLE
        
#         memo = [False for _ in range(len(nums))]
#         memo[0] = True
        
#         for end in range(1, len(memo)):
            
            
#             for start in range(end):
#                 if memo[start] and end - start <= nums[start]:
#                     memo[end] = True
#                     if len(nums) - 1 - end <= nums[end]:
#                         return True
#                     break
                               
#         return memo[-1]






### 贪心算法：累计可走的最远距离

        max_reach, n = 0, len(nums)
        for i, x in enumerate(nums):
            if max_reach < i: return False
            if max_reach >= n - 1: return True
            max_reach = max(max_reach, i + x)
            
        

        
                    