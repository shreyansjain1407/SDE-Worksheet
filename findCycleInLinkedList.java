/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class findCycleInLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode turtle = head, rabbit = head;
        while(turtle != null && rabbit != null && rabbit.next!=null){
            turtle = turtle.next;
            rabbit = rabbit.next.next;
            if(turtle == rabbit){
                return true;
            }
        }
        return false;
    }
}