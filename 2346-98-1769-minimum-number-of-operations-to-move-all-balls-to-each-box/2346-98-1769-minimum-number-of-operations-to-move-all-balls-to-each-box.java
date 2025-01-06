class Solution {
    public int[] minOperations(String boxes) {
        char[]boxesChar = boxes.toCharArray();
        int n = boxesChar.length;

        int[] leftCounts = new int[n];
        int[] leftMoves = new int[n];

        // moves to index i from left
        // moves to index [i-1] from left + num of boxes to the left of index [i - 1]: each will need one more move
        // + 1 if index[i - 1] also contains a box
        for(int i = 1; i < n; i++){
            leftMoves[i] = leftMoves[i - 1] + leftCounts[i - 1];
            leftCounts[i] = leftCounts[i - 1];

            if(boxesChar[i - 1] == '1'){
                leftMoves[i] += 1;
                leftCounts[i] += 1;
            }
        }

        int[] rightCounts = new int[n];
        int[] rightMoves = new int[n];

        for(int i = n - 2; i >= 0; i--){
            rightMoves[i] = rightMoves[i + 1] + rightCounts[i + 1];
            rightCounts[i] = rightCounts[i + 1];

            if(boxesChar[i + 1] == '1'){
                rightMoves[i] += 1;
                rightCounts[i] += 1;
            }
        }

        for(int i = 0; i < n; i++){
            leftMoves[i] += rightMoves[i];
        }

        return leftMoves;
    }
}