class Solution {
    public int nthUglyNumber(int n) {
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        
        q2.add(1);
        q3.add(1);
        q5.add(1);
        
        int k = 1;
        int res = 1;
        
        while(k < n){
            int t2 = q2.size() > 0 ? q2.peek() * 2 : Integer.MAX_VALUE;
            int t3 = q3.size() > 0 ? q3.peek() * 3 : Integer.MAX_VALUE;
            int t5 = q5.size() > 0 ? q5.peek() * 5 : Integer.MAX_VALUE;
            
            int temp = Math.min(t2, Math.min(t3, t5));
            
            if(temp == t2){
                q2.remove();
            }else if(temp == t3){
                q3.remove();
            }else{
                q5.remove();
            }
            
            if(res != temp){
                q2.add(res);
                q3.add(res);
                q5.add(res);
                res = temp;
                k++;
            }else{
                continue;
            }
        }
        
        
        return res;
    }
}