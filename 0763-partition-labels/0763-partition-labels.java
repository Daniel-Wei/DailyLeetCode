class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> records = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(records.containsKey(s.charAt(i))){
                records.replace(s.charAt(i),i);
            }else{
                records.put(s.charAt(i),i);
            }
        }





//        records.forEach((key, val) -> System.out.println("key: " + key + " val: " + val));

        int start = 0;
        int end = records.get(s.charAt(start));
        int pointer = 0;

        while(pointer <= end){
            if(end == s.length() - 1){
                res.add(end-start + 1);
                break;
            }
            if(pointer == end){
                res.add(end- start + 1);
                start = end + 1;
                end = records.get(s.charAt(start));
                pointer = start;
                continue;
            }
            if(records.get(s.charAt(pointer)) > end){
                end = records.get(s.charAt(pointer));
                pointer++;
                continue;
            }else{
                pointer++;
                continue;
            }
        }


        return res;
    }
}