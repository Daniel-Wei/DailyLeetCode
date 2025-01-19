class Solution {
    public int trapRainWater(int[][] heightMap) {
        int res = 0;
        PriorityQueue<Cell> boundaries = new PriorityQueue<Cell>();
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean [m][n];

        // first row
        for(int i = 0; i < n; i++){
            boundaries.add(new Cell(heightMap[0][i], 0, i));
            visited[0][i] = true;
        }

        // last row
        for(int i = 0; i < n; i++){
            boundaries.add(new Cell(heightMap[m - 1][i], m - 1, i));
            visited[m - 1][i] = true;
        }

        // other rows' first and last cells
        for(int i = 1; i < m - 1; i++){
            boundaries.add(new Cell(heightMap[i][0], i, 0));
            visited[i][0] = true;
            
            boundaries.add(new Cell(heightMap[i][n - 1], i, n - 1));
            visited[i][n - 1] = true;
        }

        while(boundaries.size() > 0){
            Cell current = boundaries.poll();
            res = BFS(current, heightMap, visited, boundaries, m, n, res, current.val);
        }

        return res;
    }

    private int BFS(Cell current, int[][] heightMap, boolean[][] visited, PriorityQueue<Cell> boundaries, int m, int n, int res, int boundary){
       
        // up
        if(current.row > 0 && !visited[current.row - 1][current.col]){
            visited[current.row - 1][current.col] = true;
            if(heightMap[current.row - 1][current.col] < boundary){
                res += boundary - heightMap[current.row - 1][current.col];
                res = BFS(new Cell(heightMap[current.row - 1][current.col], current.row - 1, current.col), heightMap, visited, boundaries, m, n, res, boundary);
            }else{
                boundaries.add(new Cell(heightMap[current.row - 1][current.col], current.row - 1, current.col));
            }
        }

        // down
        if(current.row < m - 1 && !visited[current.row + 1][current.col]){
            visited[current.row + 1][current.col] = true;
            if(heightMap[current.row + 1][current.col] < boundary){
                res += boundary - heightMap[current.row + 1][current.col];
                res = BFS(new Cell(heightMap[current.row + 1][current.col], current.row + 1, current.col), heightMap, visited, boundaries, m, n, res, boundary);
            }else{
                boundaries.add(new Cell(heightMap[current.row + 1][current.col], current.row + 1, current.col));
            }
        }

        // left
        if(current.col > 0 && !visited[current.row][current.col - 1]){
            visited[current.row][current.col - 1] = true;
            if(heightMap[current.row][current.col - 1] < boundary){
                res += boundary - heightMap[current.row][current.col - 1];
                res = BFS(new Cell(heightMap[current.row][current.col - 1], current.row, current.col - 1), heightMap, visited, boundaries, m, n, res, boundary);
            }else{
                boundaries.add(new Cell(heightMap[current.row][current.col - 1], current.row, current.col - 1));
            }
        }


        // right
        if(current.col < n - 1 && !visited[current.row][current.col + 1]){
            visited[current.row][current.col + 1] = true;
            if(heightMap[current.row][current.col + 1] < boundary){
                res += boundary - heightMap[current.row][current.col + 1];
                res = BFS(new Cell(heightMap[current.row][current.col + 1], current.row, current.col + 1), heightMap, visited, boundaries, m, n, res, boundary);
            }else{
                boundaries.add(new Cell(heightMap[current.row][current.col + 1], current.row, current.col + 1));
            }
        }

        return res;
    }

    private class Cell implements Comparable<Cell>{
        int val;
        int row;
        int col;

        public Cell(int val, int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Cell other) {
            // Min-heap comparison
            return Integer.compare(this.val, other.val);
        }
    }
}