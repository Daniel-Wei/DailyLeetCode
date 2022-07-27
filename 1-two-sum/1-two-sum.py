class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashmap = {}
        
        
        
        for index, val in enumerate(nums):
            desired = target - val
            if desired in hashmap:
                return [hashmap[desired], index]
            else:
                hashmap[val] = index
        
        