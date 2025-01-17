class Solution {
    //proof: https://leetcode.com/problems/neighboring-bitwise-xor/solutions/6294111/beats-100-with-detailed-proof-even-number-of-1-s-but-is-it-always-right
    
    public boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for(int d : derived){
            sum += d;
        }

        return sum % 2 == 0;
    }
}