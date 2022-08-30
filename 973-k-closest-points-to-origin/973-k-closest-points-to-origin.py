import heapq

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        
        h = []
        
        for p in points:
            heapq.heappush(h, (p[0] ** 2 + p[1] ** 2, p))
        
        
            
        return [item[1] for item in heapq.nsmallest(k, h)]
        
        
        
        
        
        
        
#         for i in range(len(points)):
#             x, y = points[i][0], points[i][1]
#             points[i] += [x**2 + y ** 2]
            
#         points.sort(key = lambda x : x[2])
#         res = []
        
#         for i in range(k):
#             res += [[points[i][0], points[i][1]]]
            
#         return res
            
        