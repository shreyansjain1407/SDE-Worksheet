class SnapshotArray {
    TreeMap<Integer, Integer>[] snapMap;
    int snapId;
    public SnapshotArray(int length) {
        snapMap = new TreeMap[length];
        for(int i = 0; i < length; i++)
            snapMap[i] = new TreeMap<Integer, Integer>();
        snapId = 0;
    }

    public void set(int index, int val) {
        snapMap[index].put(snapId, val);
    }

    public int snap() {
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        Integer key = snapMap[index].floorKey(snap_id);
        if(key == null)return 0;
        return snapMap[index].get(key);
    }
}