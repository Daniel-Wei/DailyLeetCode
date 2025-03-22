class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        int[] degrees = new int[numCourses];

        HashMap<Integer, List<Integer>> nextCourses = new HashMap<>();

        for(int[] p : prerequisites) {
            degrees[p[0]] ++;
            List<Integer> next = nextCourses.getOrDefault(p[1], new ArrayList<Integer>());
            next.add(p[0]);
            nextCourses.put(p[1], next);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        int completed = 0;

        for(int i = 0; i < numCourses; i++) {
            if(degrees[i] == 0) {
                order[completed] = i;
                completed ++;
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int course = q.poll();
            List<Integer> next = nextCourses.getOrDefault(course, new ArrayList<Integer>()); 

            for(int c : next) {
                degrees[c] -= 1;
                if(degrees[c] == 0) {
                    q.offer(c);
                    order[completed] = c;
                    completed ++;
                }
            }
        }

        if(completed == numCourses) {
            return order;
        }else{
            return new int[0];
        }

    }
}