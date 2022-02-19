class Node{
    int val;
    Node next, prev;
    public Node(){}
    public Node(int val){
        this.val = val;
    }
}

class DoublyLinkedList{
    Node head, tail;

    public DoublyLinkedList() {
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void push(Node cur) {
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev.next = cur;
        tail.prev = cur;
    }

    public Node unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public Node peek() {
        return tail.prev;
    }
}

class MaxStack {
    TreeMap<Integer, ArrayList<Node>> map;
    DoublyLinkedList dll;
    public MaxStack() {
        map = new TreeMap<>();
        dll = new DoublyLinkedList();
    }

    public void push(int x) {
        Node cur = new Node(x);
        if(!map.containsKey(x))
            map.put(x, new ArrayList<Node>());
        map.get(x).add(cur);
        dll.push(cur);
    }

    public int pop() {
        // System.out.println("pop");
        Node removed = dll.unlink(dll.tail.prev);
        List<Node> list = map.get(removed.val);
        list.remove(list.size() - 1);
        if(list.size() == 0)map.remove(removed.val);
        return removed.val;
    }

    public int top() {
        return dll.peek().val;
    }

    public int peekMax() {
        int max = map.lastKey();
        List<Node> maxList = map.get(max);
        return maxList.get(maxList.size() - 1).val;
    }

    public int popMax() {
        int max = map.lastKey();
        List<Node> maxList = map.get(max);
        Node removed = dll.unlink(maxList.remove(maxList.size()-1));
        if(maxList.size() == 0)map.remove(max);
        return removed.val;
    }
}