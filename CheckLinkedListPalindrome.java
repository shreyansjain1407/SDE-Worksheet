class CheckLinkedListPalindrome {
    public boolean isPalindrome(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode slow = head, fast = head;
        while(slow != null){
            sb.append(slow.val);
            slow = slow.next;
            // fast = fast.next.next;
        }
        // System.out.println(slow.val + " " + fast.val);
        
        return sb.toString().equals(sb.reverse().toString());
    }
}