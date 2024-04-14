class Solution {
    public int maximalRectangle(char[][] matrix) {
       if (matrix.length == 0 || matrix[0].length == 0)
               return 0;
       var dp = new int[matrix[0].length];
       var maxArea = 0;

       for (var row : matrix) {
               for (var j = 0; j < matrix[0].length; j++)
                       dp[j] = (row[j] == '1') ? dp[j] + 1 : 0;
               maxArea = Math.max(maxArea, largestRectangleArea(dp));
       }
       return maxArea;
}

// This method is straight copied from LC 84
private int largestRectangleArea(int[] heights) {
       var n = heights.length;
       var leftSmaller = new int[n];
       var rightSmaller = new int[n];
       leftSmaller[0] = -1;
       rightSmaller[n - 1] = n;

       for (var i = 1; i < n; i++) {
   		var j = i - 1;
   		while (j >= 0 && heights[j] >= heights[i])
   			j = leftSmaller[j];
   		leftSmaller[i] = j;
       }

       for (var i = n - 2; i >= 0; i--) {
   		var j = i + 1;
   		while (j < n && heights[j] >= heights[i])
   			j = rightSmaller[j];
   		rightSmaller[i] = j;
       }

       var maxArea = 0;
       for (var i = 0; i < n; i++)
   		maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] - 1));
       return maxArea;
}
}