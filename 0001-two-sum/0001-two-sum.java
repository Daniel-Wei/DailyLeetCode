// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int[]results = new int[2];
//         for(int outer = 0; outer < nums.length; outer++)
//         {
//             for(int inner = outer + 1; inner < nums.length; inner++)
//             {
//                 if(nums[outer] + nums[inner] == target)
//                 {
//                     results[0] = outer;
//                     results[1] = inner;
//                     break;
//                 }
//             }
//         }
//         return results;
//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[]res = new int[2];


        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }




        return res;
        
    }
}