class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (o1, o2) -> {
            int p1 = (int) Math.pow(o1[0], 2) + (int) Math.pow(o1[1], 2);
            int p2 = (int) Math.pow(o2[0], 2) + (int) Math.pow(o2[1], 2);
            if(p1 >= p2){
                return 1;
            }else{
                return -1;
            }
        });

        int[][] res = Arrays.copyOf(points, k);
        return res;
    }
}