class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int i = 0;
        int count = 0;
        int result = 0;

        while(i < answers.length){
            if(i == 0 || answers[i] != answers[i - 1] || count == 0){
                count = answers[i] + 1;
                result += count;
            }

            count--;
            i++;
        }

      
        return result;
    }
}