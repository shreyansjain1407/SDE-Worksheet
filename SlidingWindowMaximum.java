class SlidingWindowMaximum {
    public int maxSlidingWindow(int[] nums, int k) {
        
    }

    //Time Limit Exceeded
    public int[] maxSlidingWindow(int[] nums, int k) {
        Queue<Integer> window = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            window.offer(nums[i]);
        }
        int[] maxWindow = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length-k; i++) {
            maxWindow[i] = window.peek();
            window.offer(nums[i+k]);
            window.remove(nums[i]);
        }
        maxWindow[maxWindow.length - 1] = window.peek();
        return maxWindow;
    }
}