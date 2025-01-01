class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int numOfOnes = 0;
        int score = 0;
        int tmp = 0;

        if(s.charAt(0) - '0' == 0){
            tmp = 1;
            score = 1;
        }else{
            tmp = -1;
            score = -1;
            numOfOnes++;
        }

        // 不需要记录右边1的数量 再reversely iterate records 用numOfOnes去减
        // 直接把正向iterate到的1 当作总和的-1就好
        // Reverse records 求和不过也就是 leftOnes + numOfRecords - rightsOnes
        for(int i = 1; i < len - 1; i++){
            char c = s.charAt(i);
            if(c - '0' == 0){
                tmp += 1;
            }else{
                tmp -= 1;
                numOfOnes += 1;
            }

            score = Math.max(score, tmp);
        }

        if(s.charAt(len - 1) - '1' == 0){
            numOfOnes++;
        }

        return score + numOfOnes;
    }
}