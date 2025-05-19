class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long res = 0;
        int i = 0;
        boolean[] visited = new boolean[values.length];

        while(i >= 0 && i < values.length && !visited[i]){
            visited[i] = true;
            String s = instructions[i];

            if(s.equals("jump")){
                i += values[i];
            }else{
                res += values[i];
                i++;
            }
        }

        return res;
    }
}