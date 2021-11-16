class MidOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode cur = head, next = head;
        while(next!=null && next.next!= null){
            cur = cur.next;
            next = next.next.next;
        }
        
        return cur;
    }
}