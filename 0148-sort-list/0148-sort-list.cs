/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode SortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // cut off the link between first and second halves
        prev.next = null;

        // step 2. sort each half
        ListNode l1 = SortList(head);
        ListNode l2 = SortList(slow);

        // step 3. merge l1 and l2
        return Merge(l1, l2);
    }
    
    private ListNode Merge(ListNode n1, ListNode n2){
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        
        while(n1 != null && n2 != null){
            ListNode temp = new ListNode();
            curr.next = temp;
            curr = temp;
            
            if(n1.val < n2.val){
                curr.val = n1.val;
                n1 = n1.next;
            }else{
                curr.val = n2.val;
                n2 = n2.next;
            }
        }
        
        if(n1 != null){
            curr.next = n1;
        }
        
        if(n2 != null){
            curr.next = n2;
        }
        
        return dummyHead.next;
    }
}