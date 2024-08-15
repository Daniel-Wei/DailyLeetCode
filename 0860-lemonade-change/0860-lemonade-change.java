class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[3];
        boolean res = true;
        
        for(int bill : bills){
            switch(bill){
                case 20:
                    cash[2] += 1;
                    
                    if(cash[1] > 0 && cash[0] > 0){
                        cash[1] -= 1;
                        cash[0] -= 1;
                    }else if(cash[0] > 2){
                        cash[0] -= 3;
                    }else{
                        res = false;
                        break;
                    }
                    break;
                case 10:
                    cash[1] += 1;
                    if(cash[0] > 0){
                        cash[0] -= 1;
                    }else{
                        res = false;
                        break;
                    }
                    break;
                default:
                    cash[0] += 1;
            }
        }
        
        return res;
    }
}