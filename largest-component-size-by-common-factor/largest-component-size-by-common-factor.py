# class Solution:
#     def largestComponentSize(self, nums: List[int]) -> int:
#         nums.sort()
#         parents = list(range(nums[-1] + 1))
#         res_par = set()
        
#         def find(x, path_len = 1):
#             if x != parents[x]:
#                 return find(parents[x], path_len + 1)
#             return [x, path_len]

#         def union(node1, node2):
#             find_res1 = find(node1)
#             find_res2 = find(node2)

#             if find_res1[0] != find_res2[0]:
#                 if find_res1[1] > find_res2[1]:
#                     parents[find_res2[0]] = find_res1[0]
#                 else:
#                     parents[find_res1[0]] = find_res2[0]
        
#         for x in range(2, nums[-1] + 1):
#             for y in range(2*x, nums[-1] + 1, x):
#                 union(x, y)
#         print(parents)

#         for x in nums:
#             if find(x)[0] not in res_par:
#                 print(find(x)[0])
#                 res_par.add(find(x)[0])
                
#         return len(nums) // len(res_par)
    

# Our disjoint set
class DSU:
    def __init__(self, N):
        self.p = list(range(N))
	# keep finding til we reach the parent
    def find(self, x):
        if self.p[x] != x:
            self.p[x] = self.find(self.p[x])
        return self.p[x]
        
	# point y to x (x as parent)
    def union(self, x, y):
        xr, yr = self.find(x), self.find(y)
        self.p[xr] = yr

class Solution:
	# Function to generate primes set for number n
    def primes_set(self,n):
        for i in range(2, int(math.sqrt(n))+1):
            if n % i == 0:
                return self.primes_set(n//i) | set([i])
        return set([n])
        
    def largestComponentSize(self, A):
        n = len(A)
        UF = DSU(n)
        primes = defaultdict(list)
        # calculate primes set for all elements in A
        for i, num in enumerate(A):
            pr_set = self.primes_set(num)
            for q in pr_set: primes[q].append(i)
		# union disjoint set based on same primes
        for _, indexes in primes.items():
            for i in range(len(indexes)-1):
                UF.union(indexes[i], indexes[i+1])
		# Count the apperance of parents, return the maxium one
		# Since all connected nodes will point to same parent
        return max(Counter([UF.find(i) for i in range(n)]).values())
            