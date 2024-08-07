class Solution {
    public String numberToWords(int num) {
        
        if(num == 0){
            return "Zero";
        }
        List<Integer> scientificDigits = new ArrayList<Integer>();
        String[] scientificNotations = new String[3];
        scientificNotations[0] = " Thousand";
        scientificNotations[1] = " Million";
        scientificNotations[2] = " Billion";
        
        while(num != 0){
            scientificDigits.add(num % 1000);
            num /= 1000;
        }
        
        String res = "";
        
        String[] oneToNine = new String[9];
        String[] tenToNineteen = new String[10];
        String[] twentyToNinety = new String[8];
        
        oneToNine[0] = "One";
        oneToNine[1] = "Two";
        oneToNine[2] = "Three";
        oneToNine[3] = "Four";
        oneToNine[4] = "Five";
        oneToNine[5] = "Six";
        oneToNine[6] = "Seven";
        oneToNine[7] = "Eight";
        oneToNine[8] = "Nine";
        
        tenToNineteen[0] = "Ten";
        tenToNineteen[1] = "Eleven";
        tenToNineteen[2] = "Twelve";
        tenToNineteen[3] = "Thirteen";
        tenToNineteen[4] = "Fourteen";
        tenToNineteen[5] = "Fifteen";
        tenToNineteen[6] = "Sixteen";
        tenToNineteen[7] = "Seventeen";
        tenToNineteen[8] = "Eighteen";
        tenToNineteen[9] = "Nineteen";
        
        twentyToNinety[0] = "Twenty";
        twentyToNinety[1] = "Thirty";
        twentyToNinety[2] = "Forty";
        twentyToNinety[3] = "Fifty";
        twentyToNinety[4] = "Sixty";
        twentyToNinety[5] = "Seventy";
        twentyToNinety[6] = "Eighty";
        twentyToNinety[7] = "Ninety";
        
        res += convertToString(scientificDigits.get(0), oneToNine, tenToNineteen, twentyToNinety).trim();
        
        for(int i = 1; i < scientificDigits.size(); i++){
            int curr = scientificDigits.get(i);
            
            if(curr > 0){
                res = convertToString(curr, oneToNine, tenToNineteen, twentyToNinety)                                                           + scientificNotations[i - 1] 
                    + (res.length() > 0 ? " ": "") 
                    + res;
            }
            
        }
        
        return res;
    }
    
    private String convertToString(int num, String[] oneToNine, String[] tenToNineteen, String[] twentyToNinety){
        String res = "";
        int k = 2;
        
        
        while(num != 0 && k >= 0){
            int curr = num / ((int)Math.pow(10, k));
            
            if(curr != 0){
                if(k == 2){
                    res += oneToNine[curr - 1] + " Hundred";
                    
                    if(num % 100 != 0){
                        res += " ";
                    }
                }else if(k == 1){
                    if(curr == 1){
                        int next = num - 10;
                        res += tenToNineteen[next];
                        k = 0;
                    }else{
                        res += twentyToNinety[curr - 2];
                        
                        if(num % 10 != 0){
                            res += " ";
                        }
                    }
                }else{
                    res += oneToNine[curr - 1];
                }
                
                num %= ((int)Math.pow(10, k));
            }
            
            k--;
           
            
        }
        
        return res;
        
        
    }
}