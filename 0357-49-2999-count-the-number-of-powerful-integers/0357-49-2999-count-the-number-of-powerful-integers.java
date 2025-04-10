// class Solution {
//     public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
//         long y = Long.parseLong(s);


//         return calculate(finish, y, limit) - calculate(start, y, limit);
//     }

//     private long calculate(long x, long y, int limit){
//         int xDigits = (int)(Math.log10(x)+1);
//         int yDigits = (int)(Math.log10(y)+1);

//         if(xDigits < yDigits){
//             return 0;
//         }

//         if(xDigits == yDigits){
//             return x < y ? 1 : 0;
//         }

//         int digitsDiff = xDigits - yDigits;
//         long result = 1; // suffix itself
        
//         // mid
//         // except for the leftmost bit, 0 is allowed
//         for(int i = 1; i < digitsDiff; i++){
//             result += Math.pow(limit, 1) * Math.pow(limit + 1, i - 1);
//         }

//         long last = 1;
//         char[] charsX = String.valueOf(x).toCharArray();

//         for(int i = xDigits - yDigits - 1; i > 0; i--){
//             int d = (int)(charsX[i] - '0');
//             last *= (Math.min(d, limit) + 1); // 0 allowed
//         }

//         int leftMost = (int)(charsX[0] - '0');

//         last *= Math.min(leftMost, limit);
        
//         result += last;

//         if(leftMost <= limit){
//             boolean lessThanS = false;
//             char[] charsY = String.valueOf(y).toCharArray();

//             for(int i = charsX.length - 1; i >= charsX.length - yDigits; i--){
//                 if((int)(charsX[i] - '0') < (int)(charsY[i - digitsDiff] - '0')){
//                     lessThanS = true;
//                     break;
//                 }
//             }

            

//             result -= 1;
//         }

//         return result;
//     }
// }

class Solution {

    public long numberOfPowerfulInt(
        long start,
        long finish,
        int limit,
        String s
    ) {
        String start_ = Long.toString(start - 1);
        String finish_ = Long.toString(finish);
        return calculate(finish_, s, limit) - calculate(start_, s, limit);
    }

    private long calculate(String x, String s, int limit) {
        if (x.length() < s.length()) {
            return 0;
        }
        if (x.length() == s.length()) {
            return x.compareTo(s) >= 0 ? 1 : 0;
        }

        String suffix = x.substring(x.length() - s.length());
        long count = 0;
        int preLen = x.length() - s.length();

        for (int i = 0; i < preLen; i++) {
            int digit = x.charAt(i) - '0';
            if (limit < digit) {
                count += (long) Math.pow(limit + 1, preLen - i);
                return count;
            }
            count +=
                (long) (digit) * (long) Math.pow(limit + 1, preLen - 1 - i);
        }
        if (suffix.compareTo(s) >= 0) {
            count++;
        }

       
        return count;
    }
}