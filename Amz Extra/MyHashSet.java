class MyHashSet {
    Bucket[] buckets;
    int hash = 2069;
    public MyHashSet() {
        buckets = new Bucket[hash];
    }

    public void add(int key) {
        int curHash = key % hash;
        buckets[curHash].add(key);
    }

    public void remove(int key) {
        int curHash = key % hash;
        buckets[curHash].remove(key);
    }

    public boolean contains(int key) {
        int curHash = key % hash;
        return buckets[curHash].contains(key);
    }
}

class Bucket{
    LinkedList<Integer> values;
    public Bucket(){
        values = new LinkedList<>();
    }

    public void add(int key) {
        if(!values.contains(key))
            values.addFirst(key);
    }

    public void remove(Integer key) {
        values.remove(key);
    }

    public boolean contains(int key) {
        int index = values.indexOf(key);
        return index != -1;
    }
}