class MyHashMap {
    int hash = 2069;
    List<Bucket> hashList;// = new ArrayList<>();
    public MyHashMap() {
        hashList = new ArrayList<>();
        for(int i = 0; i < hash; i++){
            hashList.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashVal = key % hash;
        hashList.get(hashVal).add(key, value);
    }

    public int get(int key) {
        int hashVal = key % hash;
        return hashList.get(hashVal).getValue(key);
    }

    public void remove(int key) {
        int hashVal = key % hash;
        hashList.get(hashVal).remove(key);
    }
}
class Bucket{
    List<Node> curList;// = new LinkedList<>();
    public Bucket(){
        curList = new LinkedList<>();
    }

    public void add(int key, int value) {
        for (Node node : curList) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }
//        Node cur = new Node(key, value);
        curList.add(new Node(key, value));
    }

    public int getValue(int key) {
        for (Node node : curList) {
            if (node.key == key)
                return node.val;
        }
        return -1;
    }

    public void remove(int key) {
        curList.removeIf(node -> node.key == key);
    }
}
class Node{
    int key, val;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}