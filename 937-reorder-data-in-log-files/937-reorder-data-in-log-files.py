class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        lets = []
        digs = []
    
        
        for log in logs:
            
            # 将digit-logs按顺序存放
            if log[-1].isdigit():
                digs += [log]
            else:
                lets +=[log]
                
        # 先sort letter-logs的内容， 再sort identifiers    
        lets.sort(key = lambda x: (x.split()[1:],  x.split()[0]))
    
        return lets + digs
                
                
                    
       
                    
                    
            
        