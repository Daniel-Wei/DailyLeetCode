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
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        int extra = 0;
        
        ListNode res = new ListNode();
        ListNode currNode = res;
        
        while(l1 != null || l2 != null){
            if(l1 != null){
                currNode.val += l1.val;
            }
            
            if(l2 != null){
                currNode.val += l2.val;
            }
            
            if(currNode.val >= 10){
                currNode.val %= 10;
                extra = 1;
            }else{
                extra = 0;
            }
            
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null? l2.next : null;
            
            if(l1 != null || l2 != null || extra == 1){
                ListNode nextNode = new ListNode(extra);
                currNode.next = nextNode;
                currNode = nextNode;
            }
        }
        
        return res;
    }
}