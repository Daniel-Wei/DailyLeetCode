class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        boolean res = true;
        
        for(int bill : bills){
            switch(bill){
                case 20:
                    if(ten > 0 && five > 0){
                        ten -= 1;
                        five -= 1;
                    }else if(five > 2){
                        five -= 3;
                    }else{
                        res = false;
                        break;
                    }
                    break;
                case 10:
                    ten += 1;
                    if(five > 0){
                        five -= 1;
                    }else{
                        res = false;
                        break;
                    }
                    break;
                default:
                    five += 1;
            }
        }
        
        return res;
    }
}