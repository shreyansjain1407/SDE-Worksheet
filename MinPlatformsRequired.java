class Train{
    public int arrival;
    public int departure;
    public int arrivalOrder;

    public Train(int arrival, int departure, int arrivalOrder) {
        this.arrival = arrival;
        this.departure = departure;
        this.arrivalOrder = arrivalOrder;
    }
}
class MinPlatformsRequired
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.

    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Train> queue = new PriorityQueue<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.arrival - o2.arrival;
            }
        });
        for (int i = 0; i < n; i++)
            queue.add(new Train(arr[i],dep[i],i));
        int numberOfPlatforms = 1;
        Queue<Train> arrivalQueue = new PriorityQueue<>(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.departure - o2.departure;
            }
        });
        arrivalQueue.add(queue.poll());
        while (queue.size() > 0){
            Train train = queue.poll();
            if(arrivalQueue.peek().departure < train.arrival){
                arrivalQueue.poll();
                arrivalQueue.offer(train);
            }else {
                arrivalQueue.offer(train);
                numberOfPlatforms++;
            }
        }
        return numberOfPlatforms;
    }

}