class minDiffHighLow {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1)return 0;
        Arrays.sort(nums);
        int i = 0,min = Integer.MAX_VALUE;
        
        while(i <= nums.length - k){
            min = Math.min(min, nums[i+k-1] - nums[i]);
            i++;
        }
        return min;
    }
}