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
        ListNode res = new ListNode();
        ListNode newHead = res;
        
        int count = 0;
        int sum = 0;
        
        while(head != null){
            if(head.val == 0){
                if(count == 0){
                    count ++;
                }else{
                    newHead.val = sum;
                    
                    if(head.next != null){
                        ListNode next = new ListNode();
                        newHead.next = next;
                        newHead = next;
                        sum = 0;
                    }
                }
            }
            
            if(count == 1){
                sum += head.val;
            }
            
            head = head.next;
        }
        
        return res;
        
    }
}