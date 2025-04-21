class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long initial = 0l;
        long min = 0l;
        long max = 0l;

        for(int diff : differences){
            initial += diff;
            min = Math.min(min, initial);
            max = Math.max(max, initial);
        }

        long numberRange = max - min;
        long boundaryRange = upper - lower;
        int result = (int)Math.max(0, boundaryRange - numberRange + 1);

        return result;
    }
}