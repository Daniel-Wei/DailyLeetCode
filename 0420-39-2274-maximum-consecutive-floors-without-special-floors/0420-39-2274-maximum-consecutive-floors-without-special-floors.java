class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int res = special[0] - bottom;

        for(int i = 1; i < special.length; i++){
            res = Math.max(res, special[i] - special[i - 1] - 1);
        }

        return Math.max(res, top - special[special.length - 1]);
    }
}