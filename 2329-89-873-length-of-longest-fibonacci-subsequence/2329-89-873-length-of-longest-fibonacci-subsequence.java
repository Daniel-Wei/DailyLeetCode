class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        // HashMap<Integer, HashSet<Integer>> m = new HashMap<>();
        HashSet<Integer> arrSet = new HashSet<>();

        for(int i = 0; i < arr.length; i++){
            arrSet.add(arr[i]);
        }
        int res = 0;

        for(int i = 0; i < arr.length; i++){
            int n1 = arr[i];

            for(int j = i + 1; j < arr.length; j++){
                int curr = dfs(arr[i], arr[j], arrSet);
                res = Math.max(res, curr);

            }
        }

        return res;
    }

    public int dfs(int prev, int curr, HashSet<Integer> arrSet){
        int length = 0;
        
        while(arrSet.contains(prev + curr)){
            int next = prev + curr;
            // HashSet<Integer> hs = m.getOrDefault(curr, new HashSet<Integer>());

            // if(!hs.contains(next)){
                // hs.add(next);
                length++;
                prev = curr;
                curr = next;
            // }
        }

        return length > 0 ? length + 2 : length;
    }

    
}