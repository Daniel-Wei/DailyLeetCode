class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> parents = new ArrayList<>();
        int n = graph.length;
    
        for(int i = 0; i < n; i++) {
            parents.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n; i++) {
            int[] neighbours = graph[i];
            for(int next : neighbours) {
                parents.get(next).add(i);
            }
        }

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(n - 1);
        List<List<Integer>> res = new ArrayList<>();

        backtrack(linkedList, parents, res);

        return res;
    }

    private void backtrack(LinkedList<Integer> linkedList, List<List<Integer>> parents, List<List<Integer>> res) {
        int prev =linkedList.peekLast();

        if(prev == 0) {
            List <Integer> newPath = new ArrayList<Integer>();
            for(int i =linkedList.size() - 1; i >=0; i--) {
                newPath.add(linkedList.get(i));
            }
            res.add(newPath);
        }

        for(int i : parents.get(prev)) {
            linkedList.offerLast(i);
            backtrack(linkedList, parents, res);
            linkedList.pollLast();
        }
    }

}