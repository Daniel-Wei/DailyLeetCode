class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        
        ### reverse rows
        n = len(matrix)
        matrix.reverse()
        
        
        ### swap symmetry
        for x in range(n):
            for y in range(x):
                matrix[x][y], matrix[y][x] = matrix[y][x], matrix[x][y]
        
        return matrix
                
        