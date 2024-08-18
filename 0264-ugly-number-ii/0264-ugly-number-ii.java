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
            int t2 = q2.peek() * 2;
            int t3 = q3.peek() * 3;
            int t5 = q5.peek() * 5;
          
            res = Math.min(t2, Math.min(t3, t5));
            
            if(res == t2){
                q2.remove();
            }else if(res == t3){
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