class Solution {
    public String removeOccurrences(String s, String part) {
        int p = part.length();
        char[] pArr = part.toCharArray();
        char resultEnd = pArr[p - 1];
        char[] record = new char[s.length()];
        int size = 0;

        
        for(char c: s.toCharArray()){
            record[size] = c;
            if(c == resultEnd && size >= p - 1){
                int i = size - 1;
                int j = p - 2;

                while(j >= 0 && record[i] == pArr[j]){
                    i--;
                    j--;
                }


                // if an occurrence is found
                if(j < 0){
                    size = i;
                }
            }

            size++;
        }



        return new String(record, 0, size);
    }
}