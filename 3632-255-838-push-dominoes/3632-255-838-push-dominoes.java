// class Solution {
//     public String pushDominoes(String dominoes) {
//         char[] chars = dominoes.toCharArray();
//         int prev = -1;
//         char prevForce = 'x';
//         int n = chars.length;

//         for(int i = 0; i < n; i++){
//             char force = dominoes.charAt(i);

//             if(force == 'L'){
//                 if(prev < 0){
//                     for(int j = i - 1; j >= 0; j--){
//                         chars[j] = 'L';
//                     }
//                 }else if(prevForce == 'R'){
//                     int curr = i;
//                     while(prev <= curr){

//                         prev++;
//                         if(curr - 1 > prev){
//                             chars[curr - 1] = 'L';
//                         }else if(curr - 1 == prev){
//                             chars[curr - 1] = '.';
//                         }
//                         curr--;
//                     }
//                 }

//                 prev = i;
//                 prevForce = 'L';
//             }else if(force == 'R'){
//                 int j = i + 1;
//                 while(j < n && chars[j] == '.'){
//                     chars[j] = 'R';
//                     j++;
//                 }

//                 if(j < n && j == i + 1 && chars[j] == 'L'){
//                     prev = -1;
//                     prevForce = '.';
//                     i = j;
//                 }else{
//                     prev = i;
//                     prevForce = 'R';
//                 }
//             }
//         }
        

//         return new String(chars);
//     }
// }


class Solution {
    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        int n = chars.length;
        HashSet<Integer> curr = new HashSet<Integer>();

        for(int i = 0; i < n; i++){
            char d = chars[i];
            if(d == 'L' || d == 'R'){
                curr.add(i);
            }
        }

        while(curr.size() > 0){
            HashSet<Integer> next = new HashSet<Integer>();

            for(int i : curr){
                if(chars[i] == 'L' && i > 0){
                    int push = i - 1;
                    if(chars[push] == '.'){
                        chars[push] = 'L';
                        next.add(push);
                    }else if(chars[push] == 'R' && next.contains(push)){
                        next.remove(push);
                        chars[push] = '.';
                    }
                    
                }else if(chars[i] == 'R' && i < n - 1){
                    int push = i + 1;
                    if(chars[push] == '.'){
                        chars[push] = 'R';
                        next.add(push);
                    }else if(chars[push] == 'L' && next.contains(push)){
                        next.remove(push);
                        chars[push] = '.';
                    }
                }
            }

            curr = next;
        }

        return new String(chars);
    }
}