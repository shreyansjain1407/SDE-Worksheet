class HitCounter {
    Queue<Integer> hitQueue;
    public HitCounter() {
        hitQueue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hitQueue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!hitQueue.isEmpty() && hitQueue.peek() <= timestamp - 300)
            hitQueue.poll();
        return hitQueue.size();
    }
}