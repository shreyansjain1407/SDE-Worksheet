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
class AddNumbersAsLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = l1, prev = null;
        ListNode head = new ListNode();
        cur = head;
        int carry = 0;
        while(l1 != null && l2 != null){
            int temp = l1.val + l2.val + carry;
            if(temp >= 10){
                cur.next = new ListNode(temp%10);
                carry = 1;
            }else{
                cur.next = new ListNode(temp);
                carry = 0;
            }
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            int temp = l1.val + carry;
            if(temp >= 10){
                cur.next = new ListNode(temp%10);
                carry = 1;
            }else{
                cur.next = new ListNode(temp);
                carry = 0;
            }
            cur = cur.next;
            l1 = l1.next;
        }
        while(l2 != null){
            int temp = l2.val + carry;
            if(temp >= 10){
                cur.next = new ListNode(temp%10);
                carry = 1;
            }else{
                cur.next = new ListNode(temp);
                carry = 0;
            }
            cur = cur.next;
            l2 = l2.next;
        }
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        
        return head.next;
    }
}