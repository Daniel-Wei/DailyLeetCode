class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Node[] map = new Node[n];
        int[] queueMap = new int[n];
        ArrayList<Queue<Integer>> queueList = new ArrayList<Queue<Integer>>();

        for(int i = 0; i < n; i++){
            map[i] = new Node(i, nums[i]);
        }

        Arrays.sort(map, (a, b) -> a.value - b.value);

        int i = 0;
        int queueIndex = -1;

        while(i < n){
            Queue<Integer> q = new LinkedList<Integer>();
            queueIndex++;
            q.add(map[i].value);
            queueList.add(q);
            queueMap[map[i].index] = queueIndex;

            int j = i + 1;

            while(j < n && map[j].value - map[j - 1].value <= limit){
                q.offer(map[j].value);
                queueMap[map[j].index] = queueIndex;
                j++;
            }

           i = j;

        }

        for(int k = 0; k < n; k++){
            nums[k] = queueList.get(queueMap[k]).poll();

        }

        return nums;
        
    }

    public class Node {
        public int index;
        public int value;

        public Node(int i, int v){
            this.index = i;
            this.value = v;
        }
    }
}