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
public class DetectStartOfCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new HashSet<>();
        while(cur!=null){
            if(!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return cur;
    }
}