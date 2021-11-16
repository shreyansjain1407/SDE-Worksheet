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
class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tbr = head, cur = head;
        for(int i = 0; i < n && cur != null; i++){
            cur = cur.next;
        }
        if(cur == null)return head.next;
        while(cur.next != null){
            cur = cur.next; 
            tbr = tbr.next;
        }
        tbr.next = tbr.next.next;
        return head;
    }
}