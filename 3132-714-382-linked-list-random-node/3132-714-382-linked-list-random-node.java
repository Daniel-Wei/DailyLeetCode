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
    List<Integer> lst = new ArrayList<Integer>();
    int n;
    public Solution(ListNode head) {
        while(head != null){
            lst.add(head.val);
            head = head.next;
        }
        n = lst.size();
    }
    
    public int getRandom() {
        Random r = new Random();
        int index = r.nextInt(n);
        return lst.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */