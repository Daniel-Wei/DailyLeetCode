class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int groupNumber = 1;

        HashMap<Integer, Integer> groupCounts = new HashMap<Integer, Integer>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                // unvisited 1's
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    int groupCount = dfsAssignToGroup(i, j, n, groupNumber, 0, visited, directions, grid);
                    if(groupCount == n * n){
                        return groupCount;
                    }
                    groupCounts.put(groupNumber, groupCount);
                    groupNumber++;
                }
            }
        }

        int res = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    HashSet<Integer> groupNumbers = new HashSet<Integer>();
                    for(int[] d : directions){
                        int r = i + d[0];
                        int c = j + d[1];

                        if(r >= 0 && r < n && c >= 0 && c < n && grid[r][c] == 1){
                            groupNumbers.add(visited[r][c]);
                        }
                    }

                    int curr = 1;

                    for(int g : groupNumbers){
                        curr += groupCounts.get(g);
                    }

                    res = Math.max(res, curr);
                }
            }
        }

        return res;
    }

    private int dfsAssignToGroup(int i, int j, int n, int groupNumber, int groupCount, 
        int[][] visited, int[][] directions, int[][] grid)
    {
        if(i >= 0 && i < n && j >= 0 && j < n && visited[i][j] == 0 && grid[i][j] == 1){
            groupCount++;
            visited[i][j] = groupNumber;

            for(int[] d : directions){
                groupCount = dfsAssignToGroup(i + d[0], j + d[1], n, groupNumber, groupCount, visited, directions, grid);
            }
        }

        return groupCount;
    }
}