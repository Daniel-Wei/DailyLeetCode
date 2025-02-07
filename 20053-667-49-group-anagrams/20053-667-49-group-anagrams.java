class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        char[] cs = strs[0].toCharArray();
        Arrays.sort(cs);
        String first = String.valueOf(cs);
        int order = 0;

        PriorityQueue<String[]> pq = new PriorityQueue<String[]>((a, b) -> (a[0].compareTo(b[0])));

        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);

            pq.add(new String[] {str, s});
        }

        List<String> curr = new ArrayList<String>();
        String prev = pq.peek()[0];
        curr.add(pq.poll()[1]);

        while(!pq.isEmpty()){
            if(pq.peek()[0].compareTo(prev) == 0){
                curr.add(pq.poll()[1]);
            }else{
                res.add(curr);
                prev = pq.peek()[0];
                curr = new ArrayList<String>();

                curr.add(pq.poll()[1]);
            }
        }

        res.add(curr);

        return res;

    }
}