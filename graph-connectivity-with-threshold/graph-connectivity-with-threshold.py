class Solution:
    def areConnected(self, n: int, threshold: int, queries: List[List[int]]) -> List[bool]:
        parents = list(range(n + 1))
        if threshold == 0:
            return [True] * len(queries)
        
        def find(x, path_len = 1):
            if x != parents[x]:
                return find(parents[x], path_len + 1)
            return [x, path_len]
        
        def union(node1, node2):
            find_res1 = find(node1)
            find_res2 = find(node2)
            
            if find_res1[0] != find_res2[0]:
                if find_res1[1] > find_res2[1]:
                    parents[find_res2[0]] = find_res1[0]
                else:
                    parents[find_res1[0]] = find_res2[0]
                    
#         def find(x):
#             if x != parents[x]:
#                 return find(parents[x])
#             return x
        
#         def union(node1, node2):
#             r1 = find(node1)
#             r2 = find(node2)
            
#             if r1 != r2:
#                 parents[r1] = r2
                    
            
        
        def eulerAlgorithm(a: int, b: int) -> int:
            r=a%b
            while r:
                a=b
                b=r
                r=a%b
            return b
       
        # for query in queries:
        #     if eulerAlgorithm(query[1], query[0]) > threshold:
        #         union(query[1], query[0])
        
        for x in range(threshold + 1, n + 1):
            for y in range(2*x, n + 1, x):
                union(x, y)
        
        return [find(x)[0] == find(y)[0] for x, y in queries]
                
            
        
        
        
    
        