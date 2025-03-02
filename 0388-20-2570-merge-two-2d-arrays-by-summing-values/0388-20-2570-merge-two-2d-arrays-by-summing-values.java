class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i1 = 0;
        int i2 = 0;
        List<int[]> lst = new ArrayList<>();

        while(i1 < nums1.length && i2 < nums2.length){
            int[] r1 = nums1[i1];
            int[] r2 = nums2[i2];
            int id1 = r1[0];
            int id2 = r2[0];
            int v1 = r1[1];
            int v2 = r2[1];
            if(id1 == id2){
                i1++;
                i2++;
                lst.add(new int[] {id1, v1 + v2});
            }else if (id1 < id2){
                i1++;
                lst.add(new int[] {id1, v1});
            }else{
                i2++;
                lst.add(new int[] {id2, v2});
            }
        }

        while(i1 < nums1.length){
            lst.add(new int[] {nums1[i1][0], nums1[i1][1]});
            i1++;
        }

        while(i2 < nums2.length){
            lst.add(new int[] {nums2[i2][0], nums2[i2][1]});
            i2++;
        }

        int[][] res = new int[lst.size()][2];

        for(int i = 0; i < lst.size(); i++){
            res[i] = lst.get(i);
        }



        return res;
    }
}