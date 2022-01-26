class MinCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if(sticks.length == 1)return 0;
        Queue<Integer> st = new PriorityQueue<>((a,b) -> a - b);
        for (int num: sticks)
            st.add(num);
        int total = 0;
        while(st.size() > 1){
            int temp = st.poll() + st.poll();
            total += temp;
            st.offer(temp);
        }
        return total;
    }
}