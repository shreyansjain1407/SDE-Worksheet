import java.util.*;

class LRUCache {
    HashMap<Integer, Integer> keyTime;
    HashMap<Integer, Integer> keyVal;

    Queue<Integer> throwAway = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return keyTime.get(o1) - keyTime.get(o2);
        }
    });

    int maxCapacity;
    int curTime = 0;

    public LRUCache(int capacity) {
        keyTime = new HashMap<>();
        keyVal = new HashMap<>();
        maxCapacity = capacity;
    }

    public int get(int key) {
        if (keyVal.containsKey(key)){
            throwAway.remove(key);
            keyTime.put(key, curTime++);
            throwAway.offer(key);
            return keyVal.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(keyVal.containsKey(key)){
            System.out.println("1. " + key + " " + value);
            throwAway.remove(key);
            keyTime.put(key, curTime++);
            keyVal.put(key, value);
            throwAway.offer(key);
        }else if(keyTime.size() < maxCapacity){
            System.out.println("2. " + key + " " + value);
            keyTime.put(key,curTime++);
            keyVal.put(key, value);
            throwAway.offer(key);
        }else{
            System.out.println("3. " + key + " " + value);
            int throwAwayKey = throwAway.poll();
            keyTime.remove(throwAwayKey);
            keyTime.put(key, curTime++);
            keyVal.remove(throwAwayKey);
            keyVal.put(key, value);
            throwAway.offer(key);
        }
    }
}