class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2;

        while(i >= 0 && arr[i] <= arr[i + 1]){
            i--;
        }

        if(i >= 0){
            int maxMinIdx = i + 1;
            for(int j = i + 2; j < n; j++){
                if(arr[j] < arr[i] && arr[j] > arr[maxMinIdx]){
                    maxMinIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxMinIdx];
            arr[maxMinIdx] = temp; 
        }

        
        return arr;
        


    }
}