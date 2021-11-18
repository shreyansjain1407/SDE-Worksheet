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
class ReverseLinkedListInKGRoups {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)return head;
        ListNode cur = head;
        ListNode x = cur;
        // for(int i = 0; i < k && cur!=null; i++)
        //     cur = cur.next;
        ListNode prevBegin = head;
        boolean headSet = false;
        while(cur != null){
            ListNode begin = cur;//Node that will be used to connect to the reversed list
            // prevBegin = begin;
            int i = 0;
            while(i < k && cur!=null){
                cur = cur.next;
                i++;
            }
            if(i < k)break;
            // System.out.println(cur.val);
            ListNode end = cur;
            cur = begin;
            ListNode prev = end;
            while(cur != end){
                // if(prev!=null)System.out.println(prev.val);
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
                // if(cur!=null)System.out.println(cur.val);
            }
            if(!headSet){
                head = prev;
                headSet = true;
                continue;
            }
            prevBegin.next = prev;
            prevBegin = begin;
        }
        
        return head;
    }
}