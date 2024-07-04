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
//         ListNode res = new ListNode();
//         ListNode newHead = res;
        
//         int count = 0;
//         int sum = 0;
        
//         while(head != null){
//             if(head.val == 0){
//                 if(count == 0){
//                     count ++;
//                 }else{
//                     newHead.val = sum;
                    
//                     if(head.next != null){
//                         ListNode next = new ListNode();
//                         newHead.next = next;
//                         newHead = next;
//                         sum = 0;
//                     }
//                 }
//             }
            
//             if(count == 1){
//                 sum += head.val;
//             }
            
//             head = head.next;
//         }
        
//         return res;
        
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