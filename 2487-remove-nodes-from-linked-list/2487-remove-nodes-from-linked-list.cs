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
    public ListNode RemoveNodes(ListNode head) {
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode node = head;
        
        while(node != null){
            while(s.Any() && s.Peek() != null && s.Peek().val < node.val){
                s.Pop();
                if(s.Any() && s.Peek() != null){
                    s.Peek().next = node;
                }else{
                    head = node;
                }
            }
            s.Push(node);
            node = node.next;
        }
        
        return head;
    }
}