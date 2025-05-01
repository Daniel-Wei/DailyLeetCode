class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p = players.length - 1;
        int t = trainers.length - 1;
        int result = 0;

        while(p >= 0 && t >= 0){
            int player = players[p];
            int trainer = trainers[t];

            if(trainer >= player){
                result++;
                t--;
            }

            p--;
        }

        return result;
    }
}