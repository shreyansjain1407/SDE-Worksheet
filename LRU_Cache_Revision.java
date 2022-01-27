class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int maxCapacity;
    Map<Integer, Node> kv = new HashMap<>();
    Node head = new Node(0,0), tail = new Node(0,0);
    public LRUCache(int capacity) {
        maxCapacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(kv.containsKey(key)){
            Node temp = kv.get(key);
            remove(temp);
            insert(temp);
            return temp.val;
        }
        return -1;
    }

    private void insert(Node temp) {
        temp.next = head.next;
        temp.prev = head;
        head.next = temp;
        temp.next.prev = temp;
        kv.put(temp.key, temp);
    }

    private void remove(Node temp) {
        kv.remove(temp.key);
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    public void put(int key, int value) {
        if(kv.containsKey(key)){
            Node temp = kv.get(key);
            temp.val = value;
            remove(temp);
            insert(temp);
        }else{
            Node temp = new Node(key, value);
            if(kv.size() == maxCapacity){
                remove(tail.prev);
            }
            insert(temp);
        }
    }
}