class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double a1 = Math.pow((Math.pow(o1[0], 2) + Math.pow(o1[1],2)), 0.5);
                double a2 = Math.pow((Math.pow(o2[0], 2) + Math.pow(o2[1],2)), 0.5);
                if(a1 == a2) return 0;
                return (a1 < a2)?-1:1;
            }
        });
        for(int[] num : points)
            queue.offer(num);

        int[][] output = new int[k][2];
        int i = 0;
        while(i < k)
            output[i++] = queue.poll();

        return output;
    }
}