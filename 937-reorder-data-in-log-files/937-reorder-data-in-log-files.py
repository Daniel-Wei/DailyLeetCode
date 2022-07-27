class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        lets = []
        digs = []
    
        
        for log in logs:
            if log[-1].isdigit():
                digs += [log]
            else:
                lets +=[log]
                
                
        lets.sort(key = lambda x: (x.split()[1:],  x.split()[0]))
    
        return lets + digs
                
                
                    
       
                    
                    
            
        