class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int i = 1;
        while(i < arr.length){
            int k = 1;
            int j = i + 1;

            if(arr[i] > arr[i-1]){
                k = 2;
                while(j < arr.length){
                    if((k % 2 == 0 && arr[j] < arr[j - 1]) || (k % 2 == 1 && arr[j] > arr[j - 1])){
                        k++;
                        j++;
                    }else{
                        break;
                    }
                }
            }

            if(arr[i] < arr[i-1]){
                k = 2;
                while(j < arr.length){
                    if((k % 2 == 0 && arr[j] > arr[j - 1]) || (k % 2 == 1 && arr[j] < arr[j - 1])){
                        k++;
                        j++;
                    }else{
                        break;
                    }
                }
            }

            i = j;
            res = Math.max(res, k);
        }

        return res;

    }
}