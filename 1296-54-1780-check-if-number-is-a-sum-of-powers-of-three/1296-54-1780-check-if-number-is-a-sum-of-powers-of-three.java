class Solution {
    public boolean checkPowersOfThree(int n) {
        int reminder = 0;

        while(n > 0){
            reminder = n % 3;
            if(reminder > 1){
                return false;
            }

            n /= 3;
        }

        return true;
    }
}