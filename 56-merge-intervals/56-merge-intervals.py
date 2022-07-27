class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda x : x[0])
        left, right = intervals[0][0], intervals[0][1]
        res = []
        
        for i in range(1, len(intervals)):
            curr_l, curr_r = intervals[i][0], intervals[i][1]
            if curr_l <= right:
                if curr_r > right:
                    right = curr_r
            else:
                res += [[left, right]]
                left, right = curr_l, curr_r
                
        res += [[left, right]]
        return res
                    
            
            
        