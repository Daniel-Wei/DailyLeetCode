class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        d = {0 : 1}
        counter = sums = 0
        for i, num in enumerate(nums):
            sums += num
            if sums - k in d:
                counter += d[sums-k]
            if sums not in d:
                d[sums] = 1
            else:
                d[sums] += 1
        return counter
        