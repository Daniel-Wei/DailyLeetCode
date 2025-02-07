class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s= new Stack<Integer>();

        for(String t : tokens){
            switch(t){
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                
                case "-":
                    s.push(-s.pop() + s.pop());
                    break;
                
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                
                case "/":
                    int n1 = s.pop();
                    int n2 = s.pop();
                    s.push(n2 / n1);
                    break;
                
                default:
                    s.push(Integer.parseInt(t));
                    break;
            }
        }

        return s.pop();
    }
}