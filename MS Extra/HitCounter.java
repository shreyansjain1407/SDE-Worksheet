class HitCounter {
    Queue<Integer> hitQueue;
    public HitCounter() {
        hitQueue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hitQueue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        int prevTime = timestamp - 300;
        while(!hitQueue.isEmpty() && hitQueue.peek()<=prevTime)
            hitQueue.poll();
        return hitQueue.size();
    }
}