class Solution {
    public int nthUglyNumber(int n) {
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        
        q2.add(1);
        q3.add(1);
        q5.add(1);
        
        HashSet<Integer> hs = new HashSet<Integer>();
        hs.add(1);
        
        int k = 1;
        int res = 1;
        
        while(k < n){
            int t1 = Integer.MAX_VALUE;
            int t2 = Integer.MAX_VALUE;
            int t3 = Integer.MAX_VALUE;
            
            if(q2.size() > 0){
                t1 = q2.peek() * 2;
            }
            
            if(q3.size() > 0){
                t2 = q3.peek() * 3;
            }
            
            if(q5.size() > 0){
                t3 = q5.peek() * 5;
            }
            
            res = Math.min(t1, Math.min(t2, t3));
            
            if(res == t1){
                q2.remove();
            }else if(res == t2){
                q3.remove();
            }else{
                q5.remove();
            }
            
            if(!hs.contains(res)){
                q2.add(res);
                q3.add(res);
                q5.add(res);
                hs.add(res);
                k++;
            }else{
                continue;
            }
        }
        
        
        return res;
    }
}