class Solution {
    public String maskPII(String s) {
        s = s.toLowerCase();
        int last = s.charAt(s.length() - 1) - 'a';
        if(last >= 0 && last <= 26){
            return maskEmailAddress(s);
        }

        return maskPhoneNumber(s);
    }

    private String maskEmailAddress(String s){
        String[] temp = s.toLowerCase().split("@");
        StringBuilder sb = new StringBuilder();
        sb.append(temp[0].charAt(0));

        for(int i = 0; i < 5; i++){
            sb.append('*');
        }
        sb.append(temp[0].charAt(temp[0].length() - 1));
        sb.append('@');
        sb.append(temp[1]);

        return sb.toString();

    }

    private String maskPhoneNumber(String s){
        s = s.toLowerCase().replace("+", "");
        s = s.replace("-", "");
        s = s.replace("(", "");
        s = s.replace(")", "");
        s = s.replace(" ", "");

        int n = s.length();

        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(n - 4));
        sb.insert(0, '-');
        insertAsterisks(sb, 3);
        sb.insert(0, '-');
        insertAsterisks(sb, 3);

        if(n > 10){
            sb.insert(0, '-');
            insertAsterisks(sb, n - 10);
            sb.insert(0, '+');
        }

        return sb.toString();
        
    }

    private void insertAsterisks(StringBuilder sb, int n){
        for(int i = 0; i < n; i++){
            sb.insert(0, '*');
        }
    }
}