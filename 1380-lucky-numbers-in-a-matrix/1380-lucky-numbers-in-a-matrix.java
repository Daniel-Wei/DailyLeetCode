class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> colMaxIndices = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < matrix.length; i++){
            int rowMinIndex = getRowMinIndex(matrix[i]);
            if(i == getColMaxIndex(rowMinIndex, matrix, colMaxIndices)){
                luckyNumbers.add(matrix[i][rowMinIndex]);
            }
        }
        
        return luckyNumbers;
    }
    
    private int getRowMinIndex(int[]row){
        int index = 0;
        for(int i = 1; i < row.length; i++){
            if(row[i] < row[index]){
                index = i;
            }
        }
        
        return index;
    }
    
    private int getColMaxIndex(int colIndex, int[][] matrix, HashMap<Integer, Integer> colMaxIndices){
        
        if(!colMaxIndices.containsKey(colIndex)){
            int index = 0;
            for(int i = 0; i < matrix.length; i++){
                if(matrix[i][colIndex] > matrix[index][colIndex]){
                    index = i;
                }
            }
            
            colMaxIndices.put(colIndex, index);
            return index;
        }else{
            
            return colMaxIndices.get(colIndex);
        }
    }
    
}