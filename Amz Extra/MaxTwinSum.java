class MaxTwinSum {
    public int pairSum(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        if(length == 2)
            return head.val + head.next.val;
        
        length /= 2;
        cur = head;
        for(int i = 0; i < length; i++){
            cur = cur.next;
        }
        ListNode prev = null;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        cur = head;
        int maxTwin = 0;
        while(prev != null && cur != null){
            maxTwin = Math.max(maxTwin, prev.val + cur.val);
            prev = prev.next;
            cur = cur.next;
        }
        
        return maxTwin;
    }
}