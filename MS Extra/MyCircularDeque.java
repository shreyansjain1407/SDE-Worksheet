class Node{
    int val;
    Node next;
    Node prev;
    public Node(){};
    public Node(int val) {
        this.val = val;
    }
}
class MyCircularDeque {
    int capacity;
    int curCapacity;
    Node head, tail;
    public MyCircularDeque(int k) {
        capacity = k;
        curCapacity = 0;
        head = new Node();
        tail = new Node();
    }

    public boolean insertFront(int value) {
        if(curCapacity == capacity){
            return false;
        }
        if(curCapacity == 0){
            Node temp = new Node(value);
            head = temp;
            tail = temp;
            curCapacity++;
            return true;
        }
        Node temp = new Node(value);
        temp.next = head;
        temp.prev = tail;
        tail.next = temp;
        head.prev = temp;
        head = temp;
        curCapacity++;

        return true;
    }

    public boolean insertLast(int value) {
        if(curCapacity == capacity){
            return false;
        }
        if(curCapacity == 0){
            Node temp = new Node(value);
            head = temp;
            tail = temp;
            curCapacity++;
            return true;
        }
        Node temp = new Node(value);
        temp.next = head;
        temp.prev = tail;
        tail.next = temp;
        head.prev = temp;
        tail = temp;
        curCapacity++;

        return true;
    }

    public boolean deleteFront() {
        if(curCapacity == 0){
            return false;
        }
        if(curCapacity == 1){
            curCapacity--;
            return true;
        }
        head = head.next;
        tail.next = head;
        head.prev = tail;
        curCapacity--;
        return true;
    }

    public boolean deleteLast() {
        if(curCapacity == 0){
            return false;
        }
        if(curCapacity == 1){
            curCapacity--;
            return true;
        }
        tail = tail.prev;
        head.prev = tail;
        tail.next = head;
        curCapacity--;
        return true;
    }

    public int getFront() {
        if(curCapacity == 0){
            return -1;
        }
        return head.val;
    }

    public int getRear() {
        if(curCapacity == 0){
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return curCapacity == 0;
    }

    public boolean isFull() {
        return curCapacity == capacity;
    }
}