class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Long, Long> days = new HashMap<Long, Long>();

        long res = 0;
        
        for(int i = 0; i < tasks.length; i++){
            long t = tasks[i];
            if(!days.containsKey(t)){
                res = Math.max(res + 1, i + 1);
            }else{
                long d = space + 1 + days.get(t);
                res = Math.max(res + 1, d);
            }

            days.put(t, res);
        }

        return res;
    }
}