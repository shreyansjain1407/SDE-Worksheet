class MinSizeSubArrSum {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum >= target){
                while(sum >= target){
                    if(sum >= target){
                        // System.out.println(i + " " + left);
                        min = Math.min(i - left + 1, min);
                    }
                    sum -= nums[left++];
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}