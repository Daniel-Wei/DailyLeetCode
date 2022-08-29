class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        
        for index, val in enumerate(nums):
            desired = target - val
            
            # 如果所求数已经存在在hashmap中
            # return 两个indices 因为exactly one solution
            if desired in hashmap:
                return [hashmap[desired], index]
            
            # 将当前数值和index存到hashmap中
            else:
                hashmap[val] = index
        
        