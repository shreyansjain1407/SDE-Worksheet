class MinRoomsRequiredForMeetings {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0)return 0;
        Queue<int[]> meetings = new PriorityQueue<>((a,b) -> a[0] - b[0]);
//        Queue<int[]> meetings = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int count = 0;
        for(int[] interval : intervals)
            meetings.offer(interval);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(meetings.poll()[1]);
        count++;
        while(!meetings.isEmpty()){
            if(queue.peek() <= meetings.peek()[0]){
                queue.poll();
            }else{
                count++;
            }
            queue.offer(meetings.poll()[1]);
        }
        return count;
    }
}