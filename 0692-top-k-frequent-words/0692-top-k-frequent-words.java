class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if(freq.get(w) != null){
                freq.replace(w, freq.get(w), freq.get(w) + 1);
            }else{
                freq.put(w, 1);
            }
        }
        // freq.forEach((key, val) -> System.out.println("key: " + key + " val: " + val));
        Set<String> record = new HashSet<>();
        record.addAll(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        record.forEach(word -> res.add(word));
        res.sort((o1, o2) -> {
            if(freq.get(o1) < freq.get(o2)){
                return 1;
            }else if(freq.get(o1) == freq.get(o2)){
                return o1.compareTo(o2);
            }
            return -1;
        });




       return res.subList(0, k);

    }
}