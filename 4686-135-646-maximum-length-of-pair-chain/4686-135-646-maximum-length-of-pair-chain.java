class Solution {
    public int findLongestChain(int[][] pairs) {

        // Proof
        
        // If pair A is before pair B, which means A[1] <= B[1], why should always pick A over B?
        
        // Case 1: pair A[0] < B[0]
        // - 1.1  A[1] < B[1], should add A as we could still add B later
        // - 1.2  A[1] == B[1], add A or add B results in same
        
        // Case 2: A[0] == B[0]
        // - 2.1  A[1] < B[1], should add A as we could still add B later
        // - 2.2  A[1] == B[1], add A or B results in same
        
        // Case 3: A[0] > B[0]
        // - 3.1  A[1] < B[1], add A will make current tail to be A[1], which is smaller
        // - 3.2  A[1] == B[1], add A or B results in same

        // In short, as A[1] <= B[1], choose A over B will always keeps our tail smaller

        Arrays.sort(pairs, ((p1, p2) -> p1[1] - p2[1]));
        int tail = -1001;
        int res = 0;

        for(int[] p : pairs){
            if(p[0] > tail){
                res++;
                tail = p[1];
            }
        }

        
        return res;
    }
}