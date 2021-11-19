class MaxMeetingsHeldInRoom
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return (o1[2] < o2[2])?-1:1;
                else
                    return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < n; i++){
            queue.offer(new int[]{start[i],end[i], i});
        }
        int count = 0;
        int currentEnd = -1;
        while(queue.size()>0){
            int[] arr = queue.poll();
            if(arr[0] > currentEnd){
                count++;
                currentEnd = arr[1];
            }
        }

        return count;
    }
}