class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int s = score.length;
        int e = score[0].length;
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        
        for(int i = 0; i < s; i++){
            pq.add(new Pair<>(score[i][k], i));
        }
        
        int i = 0;
        int[][]res = new int[s][e];
        
        while(pq.size() > 0){
            res[i] = score[pq.poll().getValue()];
            i++;
        }
        
        return res;
    }
}