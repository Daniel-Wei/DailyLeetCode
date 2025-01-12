class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        if(n % 2 == 1){
            return false;
        }

        Stack<Integer> unlocked = new Stack<Integer>();
        Stack<Integer> lockedOpen = new Stack<Integer>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            boolean lockedIndex = locked.charAt(i) == '1';

            if(lockedIndex){
                if(c == ')'){
                    if(lockedOpen.size() > 0){
                        lockedOpen.pop();
                    }else if(unlocked.size() > 0) {
                        unlocked.pop();
                    }else{
                        return false;
                    }
                }else{
                    lockedOpen.push(i);
                }
            }else{
                unlocked.push(i);
            }
        }

        while(lockedOpen.size() > 0){
            int lockedOpenIndex = lockedOpen.pop();

            if(unlocked.isEmpty() || unlocked.peek() < lockedOpenIndex){
                return false;
            }else{
                unlocked.pop();
            }
        }

        return true;
    }
}