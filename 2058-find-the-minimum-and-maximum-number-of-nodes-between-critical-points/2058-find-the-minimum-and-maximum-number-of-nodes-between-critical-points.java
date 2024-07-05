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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int last = -1;
        int prevLocal = 0;
        int minDistance = Integer.MAX_VALUE;
        int count = 1;
        
        ListNode curr = head;
        ListNode next = head.next;
        
        while(next != null){
            if(next.next == null){
                break;
            }else{
                if((curr.val > next.val && next.next.val > next.val) || 
                   (curr.val < next.val && next.val > next.next.val)){
                    if(first == -1){
                        first = count;
                        prevLocal = count;
                    }else{
                        minDistance = Math.min(minDistance, count - prevLocal);
                        prevLocal = count;
                        last = count;
                    }
                }
                count++;
                curr = next;
                next = next.next;
            }
        }
        
        if(first == -1 || last == -1){
            return new int[]{-1, -1};
        }else{
            return new int[]{minDistance, last - first};
        }
    }
}