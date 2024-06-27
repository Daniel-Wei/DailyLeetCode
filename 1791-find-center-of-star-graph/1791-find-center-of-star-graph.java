class Solution {
    public int findCenter(int[][] edges) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int[]edge : edges){
            int s = edge[0];
            int e = edge[1];
            
            if(set.contains(s)){
                return s;
            }else{
                set.add(s);
            }
            
            if(set.contains(e)){
                return e;
            }else{
                set.add(e);
            }
        }
        
        return -1;
    }
}