class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n + 1];
        int[] res = new int[n];

        if(A[0] == B[0]){
            res[0] = 1;
        }else{
            freq[A[0]] = 1;
            freq[B[0]] = 1;
        }

        for(int i = 1; i < n; i++){
            res[i] = res[i - 1];
            
            if(freq[A[i]] == 1){
                res[i]++;
            }else{
                freq[A[i]] = 1;
            }

            if(freq[B[i]] == 1){
                res[i]++;
            }else{
                freq[B[i]] = 1;
            }
        }

        return res;
    }
}