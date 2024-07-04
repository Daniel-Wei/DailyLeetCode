/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        
        while(p2 != null){
            
            if(p2.val != 0){
                p1.val += p2.val;
            }else{
                p1.next = p2.next;
                p1 = p2.next;
                
                if(p1 == null){
                    break;
                }else{
                    p2 = p2.next;
                }
            }
            
            p2 = p2.next;
        }
        
        return head;
    }
}