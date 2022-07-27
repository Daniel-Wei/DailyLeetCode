# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            if not list2:
                return None
            else:
                return list2
        elif not list2:
            return list1
        
        else:
            res = ListNode()
            curr = res 
           
            while list1 and list2:
                dummy = ListNode()
                curr.next = dummy
                curr = curr.next
                if list1.val <= list2.val:
                    curr.val = list1.val
                    list1 = list1.next
                    
                else:
                    curr.val = list2.val
                    
                    list2 = list2.next
                
                # print(curr.val)
                
                
            curr.next = list1 if list1 else list2
                
            
            
            return res.next
        
                    
        