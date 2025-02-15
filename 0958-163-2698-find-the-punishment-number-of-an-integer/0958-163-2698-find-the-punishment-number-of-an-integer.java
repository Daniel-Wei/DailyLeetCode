class Solution {
    public int punishmentNumber(int n) {
        int res = 0;

        for(int i = 1; i <= n; i++){
            int square = (int)Math.pow(i, 2);
            if(canPartition(i, square)){
                res += square;
            }
        }

        return res;
    }

    private boolean canPartition(int target, int curr){
        if(curr < target || target < 0){
            return false;
        }

        if(target == curr){
            return true;
        }

        return canPartition(target - curr % 1000, curr / 1000) 
            || canPartition(target - curr % 100, curr / 100)
            || canPartition(target - curr % 10, curr / 10);
    }
}