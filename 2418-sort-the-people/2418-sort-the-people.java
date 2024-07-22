class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int n = heights.length;
        
        for(int i = 0; i < n; i++){
            hm.put(heights[i], i);
        }
        
        Arrays.sort(heights);
        int i = n - 1;
        String[]res = new String[n];
        
        for(int h : heights){
            res[i] = names[hm.get(h)];
            i--;
        }
        
        return res;
    }
}