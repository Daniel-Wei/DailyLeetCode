class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> dict = new HashSet<String>();

        for(String num : nums){
            dict.add(num);
        }
        
        char[] chars = new char[nums[0].length()];

        return backtrack(0, dict, chars);
    }

    private String backtrack(int k, HashSet<String> dict, char[] chars){
        if(k == chars.length){
            String curr = String.valueOf(chars);
            if(!dict.contains(curr)){
                return curr;
            }else{
                return "";
            }
        }

        for(int i = 0; i < 2; i++){
            chars[k] = (char)(i + '0');
            
            String res = backtrack(k + 1, dict, chars);

            if(res.length() == chars.length){
                return res;
            }
        }

        return "";
    }
}