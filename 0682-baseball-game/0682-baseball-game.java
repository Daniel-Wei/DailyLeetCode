class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<Integer>();
        int last = 0;
        int secondLast = 0;
        int next = 0;
        char c = '_';
        
        for(String o : operations){
            c = o.charAt(o.length() - 1);
            if(c == 'C'){
                s.pop();
            }else if(c == '+'){
                last = s.pop();
                secondLast = s.pop();
                next = last + secondLast;
                s.push(secondLast);
                s.push(last);
                s.push(next);
            }else if(c == 'D'){
                last = s.pop();
                next = last * 2;
                s.push(last);
                s.push(next);
            }else{
                s.push(Integer.parseInt(o));
            }
        }
        
        int res = 0;
        
        while(s.size() > 0){
            res += s.pop();
        }
        
        return res;
    }
}