class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, prev = null;
        while(cur!= null){
            head = cur.next;
            cur.next = prev;
            prev = cur;
            cur = head;
        }
        
        return prev;
    }
}