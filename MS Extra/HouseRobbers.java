class HouseRobbers {
    public int rob(int[] nums) {
        int n = nums.length; 
        int prev = nums[0];
        int prev2 = 0;
        for(int i = 0; i < n; i++){
            int take = nums[i];
            if(i > 1) take += prev2;
            int leave = 0 + prev;
            int cur = Math.max(take, leave);
            prev2 = prev; 
            prev = cur;
        }
        return prev;
    }
}