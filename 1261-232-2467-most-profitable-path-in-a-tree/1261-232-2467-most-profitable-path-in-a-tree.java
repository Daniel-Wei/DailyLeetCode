// class Solution {
//     int reward = Integer.MIN_VALUE;
//     public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
//         HashMap<Integer, HashSet<Integer>> g = new HashMap<>();

//         for(int[] edge : edges){
//             HashSet<Integer> nodes1 = g.getOrDefault(edge[0], new HashSet<Integer>());
//             nodes1.add(edge[1]);
//             g.put(edge[0], nodes1);

//             HashSet<Integer> nodes2 = g.getOrDefault(edge[1], new HashSet<Integer>());
//             nodes2.add(edge[0]);
//             g.put(edge[1], nodes2);
//         }

//         Stack<Integer> s = new Stack<Integer>();
//         HashSet<Integer> visited = new HashSet<Integer>();
//         backtrack_b_path(g, bob, s, visited);

//         HashMap<Integer, Integer> bobPath = new HashMap<>();
//         bobPath.put(bob, 0);
//         int step = s.size();
//         bobPath.put(0, step + 1);

//         while(!s.isEmpty()){
//             step = s.size();
//             // System.out.println(s.peek());
//             bobPath.put(s.pop(), step);
//         }

//         visited = new HashSet<Integer>();
//         visited.add(0);

//         dfs(g, visited, 0, 0, bobPath, amount, amount[0]);


//         return reward;
//     }

//     private boolean backtrack_b_path(HashMap<Integer, HashSet<Integer>> g, int curr, 
//         Stack<Integer> s, HashSet<Integer> visited)
//     {
//         HashSet<Integer> neighbours = g.get(curr);
//         visited.add(curr);

//         if(neighbours.contains(0)){
//             return true;
//         }

//         for(int n : neighbours){
//             if(!visited.contains(n) && g.containsKey(n)){
//                 visited.add(n);
//                 s.push(n);
//                 if(backtrack_b_path(g, n, s, visited)){
//                     return true;
//                 }

//                 s.pop();
//             }
//         }

//         return false;
//     }

//     private void dfs(HashMap<Integer, HashSet<Integer>> g, HashSet<Integer> visited, 
//         int curr, int step, HashMap<Integer, Integer> bobPath, int[] amount, int currReward)
//     {
//         HashSet<Integer> neighbours = g.get(curr);

//         for(int n : neighbours){
            
//             if(!visited.contains(n)){
//                 visited.add(n);
//                 step++;

//                 int nextReward = currReward;

//                 if(bobPath.containsKey(n)){

//                     int bobStep = bobPath.get(n);
                    

//                     if(bobStep == step){
//                         nextReward += amount[n] / 2;
//                     }else if(bobStep > step){
//                         nextReward += amount[n];
//                     }
//                 }else{
//                     nextReward += amount[n];
//                 }


//                 if(g.get(n).size() == 1){
//                     reward = Math.max(reward, nextReward);
//                 }else{
//                     dfs(g, visited, n, step, bobPath, amount, nextReward);
//                 }
//             }
//         }

//     }
// }


class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        ArrayList<Integer>[] graph = new ArrayList[amount.length];
        for (int i = 0; i < graph.length; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        int[] bobPath = new int[amount.length];
        Arrays.fill(bobPath, -1);
        ArrayList<Integer> path = new ArrayList<>();
        fillBobPath(bob, -1, path, graph);
        
        for (int i = 0; i < path.size(); i++) {
            bobPath[path.get(i)] = i;
        }

        return getAliceMaxScore(0, -1, 0, bobPath, graph, 0, amount);
    }

    private boolean fillBobPath(int node, int parentNode, ArrayList<Integer> path, ArrayList<Integer>[] graph) {
        if (node == 0) return true;
        for (int neighborNode : graph[node]) {
            if (neighborNode != parentNode) {
                path.add(node);
                if (fillBobPath(neighborNode, node, path, graph)) return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    private int getAliceMaxScore(int node, int parentNode, int currScore, int[] bobPath, ArrayList<Integer>[] graph, int timestamp, int[] amount) {
        if (bobPath[node] == -1 || bobPath[node] > timestamp) {
            currScore += amount[node];
        } else if (bobPath[node] == timestamp) {
            currScore += amount[node] / 2;
        }
        if (graph[node].size() == 1 && node != 0) return currScore;
        int maxScore = Integer.MIN_VALUE;
        for (int neighborNode : graph[node]) {
            if (neighborNode != parentNode) {
                maxScore = Math.max(maxScore, getAliceMaxScore(neighborNode, node, currScore, bobPath, graph, timestamp + 1, amount));
            }
        }
        return maxScore;
    }
}