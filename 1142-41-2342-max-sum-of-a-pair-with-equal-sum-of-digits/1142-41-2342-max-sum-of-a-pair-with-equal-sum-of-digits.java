class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, int[]> hm = new HashMap<>();
        int res = -1;

        for(int num : nums){
            int sum = digitsSum(num);

            if(!hm.containsKey(sum)){
                int[] curr = new int[2];
                curr[0] = num;
                curr[1] = -1;
                hm.put(sum, curr);
            }else{
                int[] record = hm.get(sum);
                if(record[1] == -1){
                    if(num > record[0]){
                        record[1] = num;
                    }else{
                        int temp = record[0];
                        record[0] = num;
                        record[1] = temp;
                    }
                }else{
                    if(num > record[1]){
                        int temp = record[1];
                        record[0] = temp;
                        record[1] = num;
                    }else if(num > record[0]){
                        record[0] = num;
                    }
                }

                res = Math.max(res, record[0] + record[1]);

                hm.put(sum, record);
            }
        }

        return res;
    }

    private int digitsSum(int num){
        int res = 0;

        while(num != 0){
            res += num % 10;
            num /= 10;
        }

        return res;
    }
}