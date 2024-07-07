class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        
        int l1 = num1.length();
        int l2 = num2.length();
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        int m = 0;
        int[]pos = new int[l1 + l2];
        
        for(int i = l1 - 1; i >=0; i--){
            for(int j = l2 - 1; j >=0; j--){
                k = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                m = k % 10;
                k /= 10;
                p1 = i+j+1;
                p2 = i+j;
                
                pos[p1] += m;
                
                if(pos[p1] >= 10){
                    pos[p2] ++;
                    pos[p1] %= 10;
                }
                
                pos[p2] += k;
                
                if(pos[p2] >= 10){
                    pos[p2 - 1] ++;
                    pos[p2] %= 10;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int r : pos){
            
            //avoid initial 0s
            if(!(sb.length() == 0 && r == 0)){
                sb.append(r);
            }
        }
        
        return sb.toString();
    }
}