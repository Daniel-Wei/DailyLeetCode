class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int res = 0;

        if(l1 % 2 != 0){
            for(int i = 0; i < l2; i++){
                res ^= nums2[i];
            }
        }

        if(l2 % 2 != 0){
            for(int i = 0; i < l1; i++){
                res ^= nums1[i];
            }
        }

        return res;
    }
}