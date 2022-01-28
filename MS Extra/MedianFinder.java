class MedianFinder {
    Queue<Integer> low;
    Queue<Integer> high;
    public MedianFinder() {
        low = new PriorityQueue<>(Comparator.reverseOrder());
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if(low.size() < high.size())
            low.offer(high.poll());
    }

    public double findMedian() {
        return low.size() > high.size() ? low.peek(): (low.peek() + high.peek())*0.5;
    }
}