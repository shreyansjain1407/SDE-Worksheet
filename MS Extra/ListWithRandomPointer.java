class ListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null)return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node newHead = new Node(head.val);
        Node newCur = newHead;
        map.put(head, newHead);
        while(cur != null){
            if(cur.next == null){
                newCur.next = null;
            }else if(map.containsKey(cur.next)){
                newCur.next = map.get(cur.next);
            }else{
                Node temp = new Node(cur.next.val);
                map.put(cur.next, temp);
                newCur.next = temp;
            }
            if(cur.random == null){
                newCur.random = null;
            }else if(map.containsKey(cur.random)){
                newCur.random = map.get(cur.random);
            }else{
                Node temp = new Node(cur.random.val);
                map.put(cur.random, temp);
                newCur.random = temp;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}