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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode first = null;
        ListNode firstPrev = null;

        while(curr != null){
            if(curr.val >= x && first == null){
                first = curr;
                firstPrev = prev;
            }

            if(first != null && curr.val < x){
                ListNode temp = curr.next;
                
                firstPrev.next = curr;
                curr.next = first;
                
                firstPrev = curr;


                prev.next = temp;
                curr = temp;
                continue;
            }

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }
}