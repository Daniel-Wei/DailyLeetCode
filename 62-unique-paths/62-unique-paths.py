class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        paths = [0 for _ in range(m)]
        for i in range(m):
            paths[i] = [0 for _ in range(n)]
        paths[0][0] = 1
        # print(paths)
        
        for i in range(m):
            for j in range(n):
                if i > 0 and  paths[i-1][j]:
                    paths[i][j] += paths[i-1][j]
                if j > 0 and  paths[i][j - 1]:
                    paths[i][j] += paths[i][j-1]
                    
        print(paths)
        
        return paths[-1][-1]
        