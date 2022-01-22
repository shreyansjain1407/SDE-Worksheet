class Node {
    int val;
    Node next;
    Node (int val){
        this.val = val;
    }
    Node (int val, Node next){
        this.val = val;
        this.next = next;
    }
}

class MyCircularQueue {
    int capacity;
    int curCapacity;
    Node head;
    Node rear;

    public MyCircularQueue(int k) {
        capacity = k;
        curCapacity = 0;
    }

    public boolean enQueue(int value) {
        if(curCapacity == capacity)return false;
        if(curCapacity == 0){
            Node temp = new Node(value);
            temp.next = temp;
            head = temp;
            rear = temp;
            curCapacity++;
            return true;
        }
        Node temp = new Node(value, head);
        temp.next = head;
        rear.next = temp;
        rear = temp;
        curCapacity++;
        return true;
    }

    public boolean deQueue() {
        if(curCapacity == 0)return false;
        head = head.next;
        rear.next = head;
        curCapacity--;
        return true;
    }

    public int Front() {
        if(curCapacity == 0)return -1;
        return head.val;
    }

    public int Rear() {
        if(curCapacity == 0)return -1;
        return rear.val;
    }

    public boolean isEmpty() {
        return curCapacity == 0;
    }

    public boolean isFull() {
        return curCapacity == capacity;
    }
}