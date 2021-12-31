class Node {
    int key;
    int value; 
    int useCounter;
    int lastUsed;

    Node(int key, int value, int curTime){
        this.key = key;
        this.value = value;
        this.useCounter = 1;
        this.lastUsed = curTime;
    }
}

class LFUCache {
    Queue<Node> queue;
    int maxCapacity;
    HashMap<Integer, Node> map;
    int curTime = 0;

    public LFUCache(int capacity) {
        queue = new PriorityQueue<Node>(new Comparator<Node>() {
            public int compare(Node node1, Node node2){
                if(node1.useCounter == node2.useCounter){
                    return node1.lastUsed - node2.lastUsed;
                }else{
                    return node1.useCounter - node2.useCounter;
                }
            }
        });
        this.maxCapacity = capacity;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            queue.remove(temp);
            int out = temp.value;
            temp.lastUsed = curTime++;
            temp.useCounter++;
            queue.offer(temp);
            return out;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            temp.value = value;
            temp.useCounter++;
            temp.lastUsed = curTime++;
            queue.remove(temp);
            queue.offer(temp);
        }else if(map.size() < maxCapacity){
            Node temp = new Node(key, value, curTime++);
            map.put(key, temp);
            queue.offer(temp);
        }else{
            Node temp = queue.poll();
            map.remove(temp.key);
            temp = new Node(key, value, curTime++);
            map.put(key, temp);
            queue.offer(temp);
        }
    }
}