class Solution {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<Robot>();
        
        for(int i = 0; i < positions.length; i++){
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        
        Collections.sort(robots, new Comparator<Robot>(){

          public int compare(Robot r1, Robot r2)
          {
             return r1.pos - r2.pos;
          }
        });

        
        Stack<Robot> s = new Stack<Robot>();
        
        for(int i = 0; i < robots.size(); i++){
            Robot curr = robots.get(i);
            
            if(curr.dire == 'R'){
                s.push(curr);
            }else{
                boolean addCurr = true;
                while(s.size() > 0 && s.peek().dire == 'R'){
                
                    Robot prev = s.peek();

                   
                    if(prev.health > curr.health){
                        prev.health -= 1;
                        healths[prev.index] -= 1;
                        healths[curr.index] = -1;
                        addCurr = false;
                        break;
                    }else if(prev.health == curr.health){
                        s.pop();
                        healths[prev.index] = -1;
                        healths[curr.index] = -1;
                        addCurr = false;
                        break;
                    }else{
                        s.pop();
                        curr.health -= 1;
                        healths[prev.index] = -1;
                        healths[curr.index] -= 1;
                    }
                    
                }
                
                if(addCurr){
                     s.push(curr);
                }
            }
            
           
        }
        
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < healths.length; i++){
            if(healths[i] > 0){
                res.add(healths[i]);
            }
        }
       
        
        return res;
    }
    
    private class Robot{
        int pos;
        int health;
        char dire;
        int index;
        
        public Robot(int pos, int health, char dire, int index){
            this.pos = pos;
            this.health = health;
            this.dire = dire;
            this.index = index;
        }
    }
}