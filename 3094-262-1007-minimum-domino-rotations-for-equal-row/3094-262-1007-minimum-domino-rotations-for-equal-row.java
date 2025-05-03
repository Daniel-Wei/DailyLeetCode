class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int result = Integer.MAX_VALUE;
        
        for(int k = 1; k < 7; k++){
            int rotations = 0;
            int count = 0;
            int same = 0;
            for(int i = 0; i < n; i++){
                if(tops[i] == k){
                    count++;
                    if(bottoms[i] == k){
                        same++;
                    }
                }
                else if(bottoms[i] == k){
                    rotations++;
                    count++;
                }
            }

            if(count == n){
                rotations = Math.min(rotations, n - rotations - same);
                result = Math.min(result, rotations);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }
}