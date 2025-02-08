class SeatManager {
    PriorityQueue<Integer> unreserved = new PriorityQueue<Integer>();
    int last;

    public SeatManager(int n) {
    }
    
    public int reserve() {
        if(unreserved.isEmpty()){
            last++;
            return last;
        }else{

            //unreserved values are always <= last
            return unreserved.poll();
        }
    }
    
    public void unreserve(int seatNumber) {
        if(seatNumber == last){
            last--;
        }else{
            unreserved.add(seatNumber);
        }
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */