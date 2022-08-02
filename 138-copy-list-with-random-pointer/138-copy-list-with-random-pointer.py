"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        head_cp = head
        start = head_cp
        while head_cp:
            curr = Node(head_cp.val)
            temp = head_cp.next
            head_cp.next = curr
            curr.next = temp
            head_cp = temp
        
        res = start.next
        
       
        
        while start:
            if start.random:
                start.next.random = start.random.next
            else:
                start.next.random = None
                
            temp = start.next.next
            
                
            if start.next.next:
                start.next.next = start.next.next.next
            else:
                start.next.next = None
           
            start = temp
            
        
        
       
            
        return res
            
            
        
       
            
            
            
            
            
            
            
            
            
        