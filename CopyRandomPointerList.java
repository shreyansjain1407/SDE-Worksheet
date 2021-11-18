/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class CopyRandomPointerList {
    public Node copyRandomList(Node head) {
        if(head == null)return head;
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        Node newHead = new Node(cur.val);
        Node newCur = newHead;
        map.put(cur,newHead);
        while(cur!=null){
            // System.out.println(cur.next.val + " " +  cur.random.val);
            if(cur.next != null && !map.containsKey(cur.next))map.put(cur.next, new Node(cur.next.val));
            if(cur.random != null && !map.containsKey(cur.random))map.put(cur.random, new Node(cur.random.val));
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        
        return newHead;
    }
}