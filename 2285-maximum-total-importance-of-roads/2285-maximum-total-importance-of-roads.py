class Solution:
    def maximumImportance(self, n: int, roads: List[List[int]]) -> int:
        degree = [0] * n
        for a, b in roads:
            degree[a] += 1
            degree[b] += 1
        importance = 0    
        for d in reversed(sorted(degree)):
            importance += d * n
            n -= 1
        return importance