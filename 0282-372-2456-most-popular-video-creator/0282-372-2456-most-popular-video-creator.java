class Solution {
    // public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
    //     HashMap<String, PriorityQueue<Pair<String, Integer>>> creatorHighest = new HashMap<>();
    //     int currentHighest = 0;
    //     HashSet<String> highestCreators = new HashSet<String>();
    //     HashMap<String, Integer> totalViews = new HashMap<String, Integer>();
    //     List<List<String>> res = new ArrayList<>();

    //     for(int i = 0; i < creators.length; i++){
    //         String c = creators[i];
    //         int currViews = totalViews.getOrDefault(c, 0) + views[i];

    //         if(currViews > currentHighest){
    //             currentHighest = currViews;
    //             highestCreators = new HashSet<String>();
    //             highestCreators.add(c);
    //         }else if(currViews == currentHighest){
    //             highestCreators.add(c);
    //         }

    //         totalViews.put(c, currViews);

    //         PriorityQueue<Pair<String, Integer>> pq = creatorHighest.getOrDefault(c, 
    //             new PriorityQueue<Pair<String, Integer>>((p1, p2) -> {
    //                 if(p1.getValue() == p2.getValue()){
    //                     return p1.getKey().compareTo(p2.getKey());
    //                 }

    //                 return p2.getValue() - p1.getValue();
    //             }));

    //         pq.add(new Pair(ids[i], views[i]));
    //         creatorHighest.put(c, pq);
    //     }

    //     for(String c : highestCreators){
    //         List<String> curr = new ArrayList<String>();
    //         curr.add(c);
    //         curr.add(creatorHighest.get(c).poll().getKey());
    //         res.add(curr);
    //     }

    //     return res;
    // }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, PriorityQueue<Pair<String, Integer>>> creatorHighest = new HashMap<>();
        HashMap<String, Long> totalViews = new HashMap<String, Long>();
        List<List<String>> res = new ArrayList<>();

        long highest = -1;

        for(int i = 0; i < creators.length; i++){
            String c = creators[i];
            long currViews = totalViews.getOrDefault(c, 0l) + views[i];
            totalViews.put(c, currViews);

            PriorityQueue<Pair<String, Integer>> pq = creatorHighest.getOrDefault(c, 
                new PriorityQueue<Pair<String, Integer>>((p1, p2) -> {
                    if(p1.getValue() == p2.getValue()){
                        return p1.getKey().compareTo(p2.getKey());
                    }

                    return p2.getValue() - p1.getValue();
                }));

            pq.add(new Pair(ids[i], views[i]));
            creatorHighest.put(c, pq);
            highest = Math.max(highest, currViews);
        }

        for(String c : totalViews.keySet()){
            if(totalViews.get(c) == highest){
                List<String> curr = new ArrayList<String>();
                curr.add(c);
                curr.add(creatorHighest.get(c).poll().getKey());
                res.add(curr);
            }
        }

        return res;
    }
}