class Solution {
    private int L;
    private boolean hasPath;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        this.L = beginWord.length();
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        if(!wordSet.contains(endWord)) return new ArrayList<>();

        // BFS
        // build a directed graph G with beginWord being the root
        // we guarantee in G, for all nodes, the dis from beginWord is the shortest
        Map<String, List<String>> adjList = new HashMap<String, List<String>>();
        wordSet.remove(beginWord); // beginWord in wordList is useless
        buildAdjList(beginWord, endWord, wordSet, adjList);
        if(this.hasPath==false) return new ArrayList<>();

        // DFS
        // get all paths from beginWord to endWord, knowing that all paths have the same shortest length
        // implement a cache to save branches that have already been visited
        return backtrack(adjList, beginWord, endWord, new HashMap<>());
    }

    public List<List<String>> backtrack(
        Map<String, List<String>> adjList, 
        String currWord, 
        String endWord,
        Map<String, List<List<String>>> cache
    ){
        if(cache.containsKey(currWord)) return cache.get(currWord);
        List<List<String>> result = new ArrayList<>();
        if(currWord.equals(endWord)){
            result.add(new ArrayList<>(Arrays.asList(currWord)));
        }else{
            List<String> neighbors = adjList.getOrDefault(currWord, new ArrayList<>());
            for(String neighbor: neighbors){
                List<List<String>> paths = backtrack(adjList, neighbor, endWord, cache);
                for(List<String> path: paths){
                    List<String> copy = new ArrayList<>(path);
                    copy.add(0, currWord);
                    result.add(copy);
                }
            }
        }
        cache.put(currWord, result);
        return result;
    }

    public void buildAdjList(String beginWord, String endWord, Set<String> unvisitedWords,  Map<String, List<String>> adjList){
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while(!q.isEmpty()){
            if(this.hasPath) break;
            int size = q.size();
            Set<String> nextLevelWords = new HashSet<>();
            for(int i=0; i<size; i++){
                String currWord = q.poll();
                List<String> nextLevelNeighbors= getNextLevelNeighbors(currWord, unvisitedWords, adjList);
                // System.out.println(currWord+" neighbors: " + nextLevelNeighbors);
                for(String nextLevelNeighbor: nextLevelNeighbors){
                    if(!nextLevelWords.contains(nextLevelNeighbor)){
                        if(nextLevelNeighbor.equals(endWord)) this.hasPath = true;
                        nextLevelWords.add(nextLevelNeighbor);
                        q.add(nextLevelNeighbor);
                    }
                }
            }
            // only after adding all edges to next level
            // can we remove next level nodes
            for(String w: nextLevelWords){
                unvisitedWords.remove(w);
            }
        }
    }

    public List<String> getNextLevelNeighbors(String word, Set<String> unvisitedWords, Map<String, List<String>> adjList){
        // for every char -- K *
        // replace it with 26 letters -- 26 *
        // check if it exists in wordSet -- O(1)
        List<String> neighbors = new ArrayList<>();
        char[] wordSeq = word.toCharArray();
        for(int i=0; i<this.L; i++){
            char oldC = wordSeq[i];
            for(int j=0; j<26; j++){
                char newC = (char)('a'+j);
                if(newC==oldC) continue;
                wordSeq[i]=newC;
                String newWord = new String(wordSeq);
                if(unvisitedWords.contains(newWord)){
                    neighbors.add(newWord);
                }
                wordSeq[i] = oldC;
            }
        }
        adjList.put(word, neighbors);
        return neighbors;
    }
}