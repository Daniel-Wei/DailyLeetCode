class TreeNode:
    def __init__(self,index=0, infoTime=0, next=None):
        self.index = index
        self.infoTime = infoTime
        self.next = next
        

class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        if n == 1:
            return 0
        
        tree = [[] for i in range(n)]
        
        for i in range(n):
            if i != headID:
                tree[manager[i]] += [i]
                
        
        #print(tree)
        
        self.end = []
        
        
        def dfs(nodes, acc):
            if len(nodes) == 0:
                self.end += [acc]
                #print(self.end)
                
            curr = acc
            for node in nodes:
                #print(node)
                next = acc + informTime[node]
               
                dfs(tree[node], next)
                
                
                
                
        dfs(tree[headID], 0)
        #print(tree)
        #print(self.end)
        
        return informTime[headID] + max(self.end)
                
            