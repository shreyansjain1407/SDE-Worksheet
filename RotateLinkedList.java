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
class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return head;
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        
        int rotate = k % length;
        if(rotate == 0)return head;
        
        cur = head;
        ListNode fast = head;
        for(int i = 0; i < rotate && cur!=null; i++){
            fast = fast.next;
        }
        
        while(fast.next!=null){
            fast = fast.next;
            cur = cur.next;
        }
        // System.out.println(cur.val);
        fast.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
}