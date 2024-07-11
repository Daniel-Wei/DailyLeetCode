class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        StringBuilder sb = new StringBuilder();
        String[]folders = path.split("/");
        
        for(String f : folders){
            
            if(f.equals("..")){
                if(s.size() > 0){
                    s.pop();
                }
                continue;
            }else if(f.length() > 0 && !f.equals(".")){
                s.push(f);
            }
           
        }
        
        while(s.size() > 0){
            sb.insert(0, "/" + s.pop());
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
}