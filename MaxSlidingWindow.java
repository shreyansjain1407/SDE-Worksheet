class MaxSlidingWindow{
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArr = new int[nums.length-k+1];
        int j = 0;
        Deque<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(!queue.isEmpty() && queue.peek() == i-k){
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k-1){
                maxArr[j++] = nums[queue.peek()];
            }
        }
        return maxArr;
    }
}