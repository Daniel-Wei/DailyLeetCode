class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        List<Integer> arr = arrays.get(0);
        int max = arr.get(arr.size() - 1);
        int min = arr.get(0);
        
        for (int i = 1; i < arrays.size(); i++) {
            arr = arrays.get(i);
            result = Math.max(result, Math.abs(arr.get(0) - max));
            result = Math.max(result, Math.abs(arr.get(arr.size() - 1) - min));
            max = Math.max(max, arr.get(arr.size() - 1));
            min = Math.min(min, arr.get(0));
        }
        
        return result;
    }
}