class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num: nums)
            queue.add(num);
        int cur = 1, max = 1;
        for(int i = 0; i < nums.length; i++){
            int x = queue.poll();
            if(queue.size()>0) {
                if(x == queue.peek()){
                    
                }else if (x + 1 == queue.peek()) {
                    cur++;
                    max = Math.max(cur, max);
                } else {
                    cur = 1;
                }
            }
        }
        return Math.max(max, cur);
    }
}