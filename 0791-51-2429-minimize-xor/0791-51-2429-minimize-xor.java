class Solution {
    public int minimizeXor(int num1, int num2) {
        int numOfSetBits1 = Integer.bitCount(num1);
        int numOfSetBits2 = Integer.bitCount(num2);
        int res = num1;

        for(int i = 0; i < 32; i++){
            // num of 1s in number 1 > num of 1s in number 2
            // (1 to the left for i bits & num 1 > 0) make sure that, at the i_th position from the right of num1, is 1
            // then res XOR (1 to the left for i bits) remove 1 at the i_th position from the right (1 XOR 1 = 0)
            if(numOfSetBits1 > numOfSetBits2 && ((1 << i) & num1) > 0){
                res ^= 1 << i;
                numOfSetBits1--;
            }

            // (1 to the left for i bits & num 1 == 0) make sure that, at the i_th position from the right of num1, is 0
            // then res XOR (1 to the left for i bits) add 1 at the i_th position from the right (1 XOR 0 = 1)
            if(numOfSetBits1 < numOfSetBits2 && ((1 << i) & num1) == 0){
                res ^= 1 << i;
                numOfSetBits1++;
            }

            if(numOfSetBits1 == numOfSetBits2){
                break;
            }
        }

        return res;
    }
}