class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<String, Integer> videos = new HashMap<String, Integer>();
        boolean[] visitedFriends = new boolean[friends.length];

        visitedFriends[id] = true;

        int l = 1;
        List<Integer> currentFriends = new ArrayList<Integer>();
        for(int f : friends[id]){
            currentFriends.add(f);
            visitedFriends[f] = true;
        }

        List<Integer> temp = new ArrayList<Integer>();

        while(l < level){
            for(int f : currentFriends){
                for(int nextF : friends[f]){
                    if(!visitedFriends[nextF]){
                        temp.add(nextF);
                        visitedFriends[nextF] = true;
                    }
                }
            }

            currentFriends = temp;
            temp = new ArrayList<Integer>();
            l++;
        }

        for(int f : currentFriends){
            watchedVideos.get(f).forEach(w -> {
                videos.put(w, videos.get(w) != null ? videos.get(w) + 1 : 1);
            });
        }

        List<String> res = new ArrayList<>(videos.keySet());
        Collections.sort(res, (e1, e2) -> videos.get(e1) == videos.get(e2) ? e1.compareTo(e2) : videos.get(e1) - videos.get(e2));
        return res;
    }
}