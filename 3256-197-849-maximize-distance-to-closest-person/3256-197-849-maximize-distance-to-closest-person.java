class Solution {
    public int maxDistToClosest(int[] seats) {
        int lastSeat = -1;
        int dict = 0;

        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                lastSeat = i;
                dict = i;
                break;
            }
        }

        for(int i = lastSeat + 1; i < seats.length; i++){
            if(seats[i] == 1){
                dict = Math.max(dict, (i - lastSeat) / 2);
                lastSeat = i;
            }
        }

        return Math.max(dict, seats.length - 1 - lastSeat);
    }
}