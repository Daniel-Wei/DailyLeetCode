class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int currStart = customers[0][0];
        
        //use double not int here, as we could get large results
        double totalWaitTime = 0;
        
        for(int i = 0; i < n; i++){
            
            //When the chef is preparing for last customer's order
            if(currStart >= customers[i][0]){
                totalWaitTime += currStart - customers[i][0] + customers[i][1];
                currStart += customers[i][1];
                
            //When current customer arrives after last customer has left
            }else{
                totalWaitTime += customers[i][1];
                currStart = customers[i][0] + customers[i][1];
            }
        }
        
        return (double)totalWaitTime / n;
    }
}