class MinMoves2 {
    //Approach 1
    public int minMoves2(int[] nums) {
        long minMoves = Integer.MAX_VALUE;
        for(int num: nums){
            long sum = 0;
            for(int n : nums){
                sum += Math.abs(num - n);
            }
            minMoves = Math.min(minMoves, sum);
        }

        return (int) minMoves;
    }
    public int minMoves2(int[] nums){
        if(nums.length == 0)return 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, count = 0;
        while(left < right){
            count += nums[right] - nums[left];
            left++;right--;
        }
        return count;
    }
}